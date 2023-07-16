package com.example.m3_t1_t2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    lateinit var btn:Button
    lateinit var edt:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn=findViewById(R.id.a1)
        edt=findViewById(R.id.edt1)


        btn.setOnClickListener {

            var name = edt.text.toString()

           /* if (name.length == 0)
            {
                edt.setError("Please enter name")
            }
            else
            {*/
                var i = Intent(applicationContext, MainActivity::class.java)
                i.putExtra("name", name)
                startActivity(i)

        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext, "start", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext, "stop", Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext, "destroy", Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext, "resume", Toast.LENGTH_SHORT).show()
    }
    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext, "pause", Toast.LENGTH_SHORT).show()
    }
    override fun onRestart() {
        super.onRestart()
        Toast.makeText(applicationContext, "restart", Toast.LENGTH_SHORT).show()
    }

}