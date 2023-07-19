package com.example.fastag

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity() {

    lateinit var rate:RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        rate=findViewById(R.id.rating)

       rate.setOnRatingBarChangeListener { ratingBar, fl, b ->
           Toast.makeText(applicationContext, ""+ratingBar.rating, Toast.LENGTH_SHORT).show()
       }


    }

    override fun onBackPressed() {

        var bk=LayoutInflater.from(applicationContext)
        var view=bk.inflate(R.layout.alert2,null)
        var al=AlertDialog.Builder(this)

        var btn1:Button = view.findViewById(R.id.bt1)
        var btn2:Button = view.findViewById(R.id.bt2)

        btn1.setOnClickListener {
            var i=Intent(applicationContext,MainActivity::class.java)
            startActivity(i)
        }
        btn2.setOnClickListener {
           finishAffinity()
        }
        al.setView(view)
        al.show()
    }
}