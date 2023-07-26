package com.example.photoview

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.github.chrisbanes.photoview.PhotoView

class Myadapter(var context: Context,var list: MutableList<Model1>):BaseAdapter()
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

    @SuppressLint("MissingInflatedId")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var layout= LayoutInflater.from(context)
        var view=layout.inflate(R.layout.design,p2,false)

        var image:ImageView =view.findViewById(R.id.c1)
        var name:TextView =view.findViewById(R.id.txt)

        image.setImageResource(list.get(p0).image)
        name.setText(list.get(p0).name)

        return view


    }
}