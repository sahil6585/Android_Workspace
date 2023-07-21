package com.example.cust

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var btn1:Button
    lateinit var btn2:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1=findViewById(R.id.btn1)
        btn2=findViewById(R.id.btn2)

        btn2.setOnClickListener {

            var l1 =LayoutInflater.from(applicationContext)
            var view1=l1.inflate(R.layout.design,null)
            var t1=AlertDialog.Builder(this)

            var btn1:Button=view1.findViewById(R.id.btn3)
            btn1.setOnClickListener {
                var i=Intent(applicationContext,MainActivity::class.java)
                startActivity(i)
            }


            t1.setView(view1)
            t1.show()

        }

        btn1.setOnClickListener {
            var l2=LayoutInflater.from(applicationContext)
            var view2=l2.inflate(R.layout.design,null)
            var t1=Toast(applicationContext)
            t1.view=view2
            t1.duration=Toast.LENGTH_SHORT
            t1.setGravity(Gravity.CENTER,0,0)
            t1.show()

        }
    }
}