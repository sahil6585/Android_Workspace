package com.example.m4_2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.m4_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn.setOnClickListener {

            var a = binding.t1.text.toString()
            var b = binding.t2.text.toString()
            var d = 0

            var data1= a.toInt()
            var data2=b.toInt()
            var data3=data1+1

           /*
            for (i in a..b)
            {
               // Toast.makeText(applicationContext,""+i,Toast.LENGTH_LONG).show()
                var i2 = Intent(applicationContext, MainActivity2::class.java)
                i2.putExtra("data", i)
                startActivity(i2)
            }*/


            var sb = StringBuffer("")
            for (i in data3..data2)
            {
                sb.append(",")
                sb.append(i)

                var i2 = Intent(applicationContext, MainActivity2::class.java)
                i2.putExtra("data", sb.toString())
                startActivity(i2)
            }
        }
    }
}