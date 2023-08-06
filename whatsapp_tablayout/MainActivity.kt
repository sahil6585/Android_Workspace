package com.example.whatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.example.whatsapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.tool)
        binding.tab.setupWithViewPager(binding.viewpager)

        setupdata()


    }




    private fun setupdata() {
        var adapter=MyAdapter(supportFragmentManager)
        adapter.adddata(Chat_fragment(),"Chats")
        adapter.adddata(Status_fragment(),"Status")
        adapter.adddata(Call_fragment(),"Calls")
        binding.viewpager.adapter=adapter
    }
}