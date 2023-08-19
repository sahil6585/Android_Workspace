package com.example.movie

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    lateinit var image:ImageView
    lateinit var d1:TextView
    lateinit var d2:TextView
    lateinit var d3:TextView
    lateinit var d4:TextView
    lateinit var d5:TextView
    lateinit var d6:TextView
    lateinit var d7:TextView
    lateinit var d8:TextView

    lateinit var e1:TextView
    lateinit var e2:TextView
    lateinit var e3:TextView
    lateinit var e4:TextView
    lateinit var e5:TextView
    lateinit var e6:TextView
    lateinit var e7:TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

       image = findViewById(R.id.i)
        d1=findViewById(R.id.dt1)
        d2=findViewById(R.id.dt2)
        d3=findViewById(R.id.dt3)
        d4=findViewById(R.id.dt4)
        d5=findViewById(R.id.dt5)
        d6=findViewById(R.id.dt6)
        d7=findViewById(R.id.dt7)
        d8=findViewById(R.id.dt8)

        e1=findViewById(R.id.b1)
        e2=findViewById(R.id.b2)
        e3=findViewById(R.id.b3)
        e4=findViewById(R.id.b4)
        e5=findViewById(R.id.b5)
        e6=findViewById(R.id.b6)
        e7=findViewById(R.id.b7)



        var i =intent
        //var pos = i.getStringExtra("photos")
         //pos2 = i.getStringExtra("pos")
        image.setImageResource(i.getIntExtra("photos",101))
        d1.setText(i.getStringExtra("t1"))
        d2.setText(i.getStringExtra("t2"))
        d3.setText(i.getStringExtra("t3"))
        d4.setText(i.getStringExtra("t4"))
        d5.setText(i.getStringExtra("t5"))
        d6.setText(i.getStringExtra("t6"))
        d7.setText(i.getStringExtra("t7"))
        d8.setText(i.getStringExtra("t8"))
        d8.setText(i.getStringExtra("t9"))

        e1.setText(i.getStringExtra("t10"))
        e2.setText(i.getStringExtra("t11"))
        e3.setText(i.getStringExtra("t12"))
        e4.setText(i.getStringExtra("t13"))
        e5.setText(i.getStringExtra("t14"))
        e6.setText(i.getStringExtra("t15"))
        e7.setText(i.getStringExtra("t16"))
        e7.setText(i.getStringExtra("t17"))





    }

}