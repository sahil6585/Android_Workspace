package com.example.email_sender

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.email_sender.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btn.setOnClickListener {

            var txt1=binding.e1.text.toString()
            var txt2=binding.e2.text.toString()
            var txt3=binding.e3.text.toString()

            var mail=Intent(Intent.ACTION_SEND)
            mail.putExtra(Intent.EXTRA_EMAIL, arrayOf(txt1))
            mail.putExtra(Intent.EXTRA_SUBJECT,txt2)
            mail.putExtra(Intent.EXTRA_TEXT, txt3)
            mail.setType("messsage/rfc822")
            startActivity(mail)

        }

    }
}