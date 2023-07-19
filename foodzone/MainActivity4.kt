package com.example.foodzone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity4 : AppCompatActivity() {
    lateinit var btn:Button
lateinit var txt:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        btn=findViewById(R.id.a3)
        txt=findViewById(R.id.a2)
        btn.setOnClickListener {
            if (txt.length() == 0)
            {
                txt.setError("please write something")
            }
            else {
                Toast.makeText(applicationContext, "THANKS FOR THE FEEDBACK", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}