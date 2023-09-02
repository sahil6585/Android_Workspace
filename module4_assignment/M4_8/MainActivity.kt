package com.example.m4_8

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.m4_8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn.setOnClickListener {
        if (binding.i1.getVisibility() === View.VISIBLE) {
            binding.i1.setVisibility(View.GONE)
            binding.i2.setVisibility(View.VISIBLE)
        } else {
            binding.i1.setVisibility(View.VISIBLE)
            binding.i2.setVisibility(View.GONE)
        }
        }
    }
}