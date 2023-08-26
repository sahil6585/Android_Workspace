package com.example.prefrencescreen

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.example.prefrencescreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences=PreferenceManager.getDefaultSharedPreferences(applicationContext)

        binding.b1.setOnClickListener {

            var i=Intent(applicationContext,MainActivity2::class.java)
            startActivity(i)
        }
        binding.b2.setOnClickListener {


            var name:String = sharedPreferences.getString("t1","\nEnter your name\n")!!
            var pass:String = sharedPreferences.getString("t2","Enter your password\n")!!
            var ans:Boolean = sharedPreferences.getBoolean("c1", false)
            var list:String = sharedPreferences.getString("l1","\nSelect list details")!!

            binding.t.append(name)
            binding.t.append(pass)
            binding.t.append(ans.toString())
            binding.t.append(list)

        }
    }
}