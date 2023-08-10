package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var list: ArrayList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var layoutManager:RecyclerView.LayoutManager=LinearLayoutManager(this)
        binding.rc.layoutManager=layoutManager

        list=ArrayList()

        list.add(Model(R.drawable.a,"Frederick"))
        list.add(Model(R.drawable.b,"Michael"))
        list.add(Model(R.drawable.c,"Sebastian"))
        list.add(Model(R.drawable.d,"Sophia"))
        list.add(Model(R.drawable.e,"Scarlett"))
        list.add(Model(R.drawable.f,"Athena"))
        list.add(Model(R.drawable.a,"Frederick"))
        list.add(Model(R.drawable.b,"Michael"))
        list.add(Model(R.drawable.c,"Sebastian"))
        list.add(Model(R.drawable.d,"Sophia"))
        list.add(Model(R.drawable.e,"Scarlett"))
        list.add(Model(R.drawable.f,"Athena"))

        var adapter=MyAdapter(applicationContext,list)
        binding.rc.adapter=adapter


    }
}