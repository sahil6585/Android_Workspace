package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context,var list: MutableList<Model>):RecyclerView.Adapter<Abc>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Abc {
     var layout=LayoutInflater.from(context)
     var view=layout.inflate(R.layout.design,parent,false)
     return Abc(view)
    }

    override fun onBindViewHolder(holder: Abc, position: Int) {
      holder.image.setImageResource(list.get(position).image)
        holder.name.setText(list.get(position).name)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}

class Abc(itemview:View) : RecyclerView.ViewHolder(itemview)
{
    var image:ImageView
    var name :TextView

    init {
        image=itemview.findViewById(R.id.img)
        name=itemview.findViewById(R.id.txt)
    }
}


