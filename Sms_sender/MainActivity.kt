package com.example.sms_sender

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager


import com.example.sms_sender.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn.setOnClickListener {

            var num=  binding.e1.text.toString()
            var msg=  binding.e2.text.toString()

            var sms:SmsManager=SmsManager.getDefault()
            var i=Intent(applicationContext,MainActivity::class.java)
            var pi:PendingIntent =PendingIntent.getActivity(applicationContext,0,i,FLAG_IMMUTABLE)
            sms.sendTextMessage(num,null,msg,pi,null)
        }

    }
}