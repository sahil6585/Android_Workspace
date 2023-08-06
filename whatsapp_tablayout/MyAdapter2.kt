package com.example.whatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity

class MyAdapter2(var req: FragmentActivity, var list: MutableList<Model>): BaseAdapter()
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
        var layout=LayoutInflater.from(req)
        var view=layout.inflate(R.layout.chat_design,p2,false)

        var img:ImageView = view.findViewById(R.id.c1)
        var nm:TextView =view.findViewById(R.id.txt1)
        var mg:TextView =view.findViewById(R.id.txt2)
        var tm:TextView =view.findViewById(R.id.txt3)

        img.setImageResource(list.get(p0).image)
        nm.setText(list.get(p0).name)
        mg.setText(list.get(p0).msg)
        tm.setText(list.get(p0).time)

    return view
    }
}