package com.example.foodzone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {

    lateinit var t:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        t=findViewById(R.id.text)
        var i=intent

        t.setText(i.getStringExtra("bill"))
    }
}