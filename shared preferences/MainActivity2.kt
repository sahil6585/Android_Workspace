package com.example.sharedpreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreference.databinding.ActivityMain2Binding
import com.example.sharedpreference.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        shared=getSharedPreferences("USER", Context.MODE_PRIVATE)
        Toast.makeText(applicationContext, "Welcome : "+shared.getString("eml","null"), Toast.LENGTH_SHORT).show()

    binding.btn.setOnClickListener {

        shared.edit().clear().commit()
        var i=Intent(applicationContext,MainActivity::class.java)
        startActivity(i)
    }
    }
}