package com.example.movie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TextView

class MyAdapter(var context: Context,var list: MutableList<Model>) : BaseAdapter()
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

        var layout= LayoutInflater.from(context)
        var view=layout.inflate(R.layout.design,p2,false)

        var img:ImageView = view.findViewById(R.id.im)
        var t1:TextView =view.findViewById(R.id.t1)
        var t2:TextView =view.findViewById(R.id.t2)

        img.setImageResource(list.get(p0).img)
        t1.setText(list.get(p0).name)
        t2.setText(list.get(p0).date)

        return view
    }

}


