package com.example.m4_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m4_2.databinding.ActivityMain2Binding
import com.example.m4_2.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        var i=intent

        binding.txt.setText(i.getStringExtra("data"))
    }
}