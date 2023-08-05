package com.example.m4_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import com.example.m4_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.b1.setOnCheckedChangeListener(this)
        binding.b2.setOnCheckedChangeListener(this)
        binding.b3.setOnCheckedChangeListener(this)
        binding.b4.setOnCheckedChangeListener(this)


    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        var n1=binding.f1.text.toString().toInt()
        var n2=binding.f2.text.toString().toInt()
        var ans=0

        if(binding.b1.isChecked)
        {
            ans=n1+n2
            Toast.makeText(applicationContext, ""+ans, Toast.LENGTH_SHORT).show()
        }
        else if(binding.b2.isChecked)
        {
            ans=n1-n2
            Toast.makeText(applicationContext, ""+ans, Toast.LENGTH_SHORT).show()
        }
        else if(binding.b3.isChecked)
        {
            ans=n1*n2
            Toast.makeText(applicationContext, ""+ans, Toast.LENGTH_SHORT).show()
        }
        else if(binding.b4.isChecked)
        {
            ans=n1/n2
            Toast.makeText(applicationContext, ""+ans, Toast.LENGTH_SHORT).show()
        }

    }
}