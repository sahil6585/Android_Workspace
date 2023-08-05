package com.example.m4_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.m4_4.databinding.ActivityMain2Binding
import com.example.m4_4.databinding.FragmentBlank2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.b1.setOnClickListener {

            var bt=BlankFragment()
            var fr:FragmentManager=supportFragmentManager
            var t:FragmentTransaction=fr.beginTransaction()
            t.replace(R.id.fid,bt).commit()
        }

        binding.b2.setOnClickListener {

            var bt=BlankFragment2()
            var fr:FragmentManager=supportFragmentManager
            var t:FragmentTransaction=fr.beginTransaction()
            t.replace(R.id.fid,bt).commit()
        }
    }
}