package com.example.m4_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m4_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.web.loadUrl("https://www.google.com")
    }
}