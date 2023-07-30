package com.example.sharedpreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var shared:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        shared=getSharedPreferences("USER", Context.MODE_PRIVATE)

        if (shared.getBoolean("USER",false) && !shared.getString("eml","")!!.isEmpty())
        {
            startActivity(Intent(applicationContext,MainActivity2::class.java))
            finish()
        }


        binding.bt1.setOnClickListener {

            var email=binding.et1.text.toString()
            var pas=binding.et2.text.toString()

            var i=Intent(applicationContext,MainActivity2::class.java)
            var editor:SharedPreferences.Editor = shared.edit()
            editor.putBoolean("USER",true)
            editor.putString("eml",email)
            editor.putString("pass",pas)
            editor.commit()
            startActivity(i)


        }

    }
}