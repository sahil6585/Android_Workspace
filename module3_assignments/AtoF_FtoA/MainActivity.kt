package com.example.atof_ftoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.atof_ftoa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn.setOnClickListener {
            var bf=BlankFragment()
            var fm:FragmentManager=supportFragmentManager
            var t:FragmentTransaction=fm.beginTransaction()
            t.replace(R.id.fl,bf).commit()
        }
    }
}