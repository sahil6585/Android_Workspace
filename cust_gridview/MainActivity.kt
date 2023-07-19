package com.example.fastag

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Adapter
import android.widget.Button
import android.widget.GridView
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import kotlinx.coroutines.MainScope

class MainActivity : AppCompatActivity() {

    lateinit var grid:GridView
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        grid=findViewById(R.id.list)
        list=ArrayList()

        list.add(Model(R.drawable.a,"Buy FASTag"))
        list.add(Model(R.drawable.b,"Apply FASTag"))
        list.add(Model(R.drawable.c,"Recharge FASTag"))
        list.add(Model(R.drawable.d,"Login Bank Prortal"))
        list.add(Model(R.drawable.e,"FASTag Full Details"))
        list.add(Model(R.drawable.f,"Activate FASTag"))
        list.add(Model(R.drawable.gg,"Close FASTag Account"))
        list.add(Model(R.drawable.h,"FASTag Replacement"))
        list.add(Model(R.drawable.i,"Toll deduction issues"))
        list.add(Model(R.drawable.j,"FASTag issue Bank toll free helpline"))
        list.add(Model(R.drawable.k,"Support 1033"))
        list.add(Model(R.drawable.l,"List of Toll"))

        var adapter=MyAdapter(applicationContext,list)
        grid.adapter=adapter


    }

    override fun onBackPressed() {

        var exit=LayoutInflater.from(applicationContext)
        var view=exit.inflate(R.layout.alert,null)
        var t1=AlertDialog.Builder(this)

        var btn1:Button =view.findViewById(R.id.btn1)
        var btn2:Button =view.findViewById(R.id.btn2)
        var btn3:Button =view.findViewById(R.id.btn3)

        btn1.setOnClickListener {
                var i=Intent(applicationContext,MainActivity2::class.java)
            startActivity(i)
        }

        btn2.setOnClickListener {
                finishAffinity()
        }
        btn3.setOnClickListener {
            var i=Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
        }
        t1.setView(view)
        t1.show()
    }
}