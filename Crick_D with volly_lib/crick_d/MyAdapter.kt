package com.example.crick_d

import android.annotation.SuppressLint
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
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MyAdapter(var context: Context, var list: MutableList<Modell>):RecyclerView.Adapter<MyView>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        var layoutInflater = LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.desing, parent, false)
        return MyView(view)
    }
    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(holder: MyView, @SuppressLint("RecyclerView") position: Int) {
        holder.txt1.setText(list.get(position).cricketer_name)

        holder.txt2.setText(list.get(position).cricketer_wickets)

        holder.txt3.setText(list.get(position).cricketer_age)

       holder.txt4.setText(list.get(position).cricketer_highest_score)
        holder.txt5.setText(list.get(position).cricketer_total_score)

           holder.itemView.setOnClickListener {
            var alert = AlertDialog.Builder(holder.itemView.context)
            alert.setTitle("SELECT ONE")
            alert.setPositiveButton("UPDATE", { dialogInterface: DialogInterface, i: Int ->
                var i = Intent(context,UpdateActivity::class.java)
                i.putExtra("id",list.get(position).id)
                i.putExtra("name",list.get(position).cricketer_name)
                i.putExtra("age",list.get(position).cricketer_age)
                i.putExtra("totalscore",list.get(position).cricketer_total_score)
                i.putExtra("highestscore",list.get(position).cricketer_highest_score)
                i.putExtra("wickets",list.get(position).cricketer_wickets)
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(i)

            })
            alert.setNegativeButton("DELETE", { dialogInterface: DialogInterface, i: Int ->
                var StringRequest: StringRequest = object : StringRequest(Request.Method.POST, "https://sahiltops3939.000webhostapp.com/API/Data/delete.php",
                    Response.Listener {
                        Toast.makeText(context, "Delete Product", Toast.LENGTH_SHORT).show()
                        var i = Intent(context, ViewActivity::class.java)
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        context.startActivity(i)
                    },
                    Response.ErrorListener {
                        Toast.makeText(context, "NO INTERNET", Toast.LENGTH_SHORT).show()
                    })
                {
                    override fun getParams(): MutableMap<String, String>? {
                        var map = HashMap<String, String>()
                        map["id"] = list.get(position).id.toString()
                        return map
                    }
                }
                var queue: RequestQueue = Volley.newRequestQueue(context)
                queue.add(StringRequest)
            })
            alert.show()
        }
    }

}
    class MyView(Itemview: View) : RecyclerView.ViewHolder(Itemview) {
        var txt1: TextView = Itemview.findViewById(R.id.cricketer_name)
        var txt2: TextView = Itemview.findViewById(R.id.cricketer_wickets)
        var txt3: TextView = Itemview.findViewById(R.id.cricketer_age)
        var txt4: TextView = Itemview.findViewById(R.id.cricketer_highest_score)
        var txt5: TextView = Itemview.findViewById(R.id.cricketer_total_score)

    }













