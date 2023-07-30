package com.example.photoview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.photoview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<Model1>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list= ArrayList()

        list.add(Model1(R.drawable.a,"Frederick"))
        list.add(Model1(R.drawable.b,"Michael"))
        list.add(Model1(R.drawable.c,"Sebastian"))
        list.add(Model1(R.drawable.d,"Sophia"))
        list.add(Model1(R.drawable.e,"Scarlett"))
        list.add(Model1(R.drawable.f,"Athena"))
        list.add(Model1(R.drawable.a,"Frederick"))
        list.add(Model1(R.drawable.b,"Michael"))
        list.add(Model1(R.drawable.c,"Sebastian"))
        list.add(Model1(R.drawable.d,"Sophia"))
        list.add(Model1(R.drawable.e,"Scarlett"))
        list.add(Model1(R.drawable.f,"Athena"))

        var adapter=Myadapter(application,list)
        binding.listview.adapter=adapter

        binding.listview.setOnItemClickListener { adapterView, view, i, l ->


            var a = Intent(applicationContext,MainActivity2::class.java)

            a.putExtra("img",list.get(i).image)
            startActivity(a)

        }


    }
}