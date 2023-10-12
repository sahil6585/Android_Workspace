package com.example.signup_signin

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
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
        holder.txt2.setText(list.get(position).product_name)
        holder.txt3.setText(list.get(position).product_price)
       holder.txt4.setText(list.get(position).product_description)
        holder.itemView.setOnClickListener {
            var alert = AlertDialog.Builder(holder.itemView.context)
            alert.setTitle("SELECT ONE")
            alert.setPositiveButton("UPDATE", { dialogInterface: DialogInterface, i: Int ->
                var i = Intent(context,MainActivity5::class.java)
                i.putExtra("myid",list.get(position).product_id)
                i.putExtra("myname",list.get(position).product_name)
                i.putExtra("myprice",list.get(position).product_price)
                i.putExtra("mydes",list.get(position).product_description)
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(i)


            })
            alert.setNegativeButton("DELETE", { dialogInterface: DialogInterface, i: Int ->
                var StringRequest: StringRequest = object : StringRequest(Request.Method.POST, "https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/productdelete.php",
                    Response.Listener {
                        Toast.makeText(context, "Delete Product", Toast.LENGTH_SHORT).show()
                        var i = Intent(context, MainActivity3::class.java)
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        context.startActivity(i)
                    },
                    Response.ErrorListener {
                        Toast.makeText(context, "NO INTERNET", Toast.LENGTH_SHORT).show()
                    })
                {
                    override fun getParams(): MutableMap<String, String>? {
                        var map = HashMap<String, String>()
                        map["product_id"] = list.get(position).product_id.toString()
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
        var txt2: TextView = Itemview.findViewById(R.id.product_name)
        var txt3: TextView = Itemview.findViewById(R.id.product_price)
       var txt4: TextView = Itemview.findViewById(R.id.product_dis)
    }













