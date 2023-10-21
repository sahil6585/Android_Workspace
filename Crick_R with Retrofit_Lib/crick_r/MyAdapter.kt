package com.example.crick_r

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyAdapter(var context: Context,var list: MutableList<Modell>):RecyclerView.Adapter<MyView>()
{

    lateinit var apiinterface: ApiInterface

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        var layoutInflater = LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.desing, parent, false)
        return MyView(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        apiinterface = ApliClient.getapiclient().create(ApiInterface::class.java)

        holder.txt1.setText(list.get(position).cricketer_name)
        holder.txt2.setText(list.get(position).cricketer_wickets)
        holder.txt3.setText(list.get(position).cricketer_age)
        holder.txt4.setText(list.get(position).cricketer_highest_score)
        holder.txt5.setText(list.get(position).cricketer_total_score)

        holder.itemView.setOnClickListener {
            var alert = AlertDialog.Builder(holder.itemView.context)
            alert.setTitle("SELECT ONE")
            alert.setPositiveButton("UPDATE", { dialogInterface: DialogInterface, i: Int ->
                var i = Intent(context, UpdateActivity::class.java)
                i.putExtra("id", list.get(position).id)
                i.putExtra("name", list.get(position).cricketer_name)
                i.putExtra("age", list.get(position).cricketer_age)
                i.putExtra("totalscore", list.get(position).cricketer_total_score)
                i.putExtra("highestscore", list.get(position).cricketer_highest_score)
                i.putExtra("wickets", list.get(position).cricketer_wickets)
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(i)

            })
            alert.setNegativeButton("DELETE", { dialogInterface: DialogInterface, i: Int ->

                var call : Call<Void> = apiinterface.deletedata(list.get(position).id)

                call.enqueue(object:Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {

                        Toast.makeText(context,"Deleted", Toast.LENGTH_LONG).show()
                        val a = Intent(context,ViewActivity::class.java)
                        a.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        context.startActivity(a)
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        Toast.makeText(context,"Fail",Toast.LENGTH_LONG).show()
                    }
                })
            })
            alert.show()

        }
    }
}

class MyView (Itemview : View):RecyclerView.ViewHolder(Itemview)
{
    var txt1: TextView = Itemview.findViewById(R.id.cricketer_name)
    var txt2: TextView = Itemview.findViewById(R.id.cricketer_wickets)
    var txt3: TextView = Itemview.findViewById(R.id.cricketer_age)
    var txt4: TextView = Itemview.findViewById(R.id.cricketer_highest_score)
    var txt5: TextView = Itemview.findViewById(R.id.cricketer_total_score)
}
