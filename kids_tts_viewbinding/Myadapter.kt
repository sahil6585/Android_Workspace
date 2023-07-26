package com.example.kids

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class Myadapter(var context: Context,var list: MutableList<Modell>) : BaseAdapter()
{
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var layout=LayoutInflater.from(context)
        var view=layout.inflate(R.layout.disign,p2,false)

        var im:ImageView = view.findViewById(R.id.img)
        var nm:TextView = view.findViewById(R.id.f1)

        im.setImageResource(list.get(p0).Image)
        nm.setText(list.get(p0).name)

        return view
    }
}