package com.example.kids

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.kids.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.login.setOnClickListener {

            var name=binding.name.text.toString()
            var password=binding.pw.text.toString()

            if (name.length==0 && password.length==0)
            {
                binding.name.setError("Please Enter username")
                binding.pw.setError("Please Enter password")
            }
            else if (name.length==0 )
            {
                binding.name.setError("Please Enter username")
            }
            else if (password.length==0 )
            {
                binding.pw.setError("Please Enter password")
            }
            else if (!name.equals("Sahil")   )
            {
                binding.name.setError("Enter only Sahil's username")
            }
            else if (!password.equals("sahil123"))
            {
                binding.pw.setError("Enter only Sahil's password")
            }
            else
            {
                if (name.equals("Sahil") && password.equals("sahil123") )
                {
                    Toast.makeText(applicationContext, "LOGIN SUCCESSFULLY", Toast.LENGTH_SHORT).show()
                    var i = Intent(applicationContext,MainActivity2::class.java)
                    startActivity(i)
                }
                else
                {
                    Toast.makeText(applicationContext, "Please enter right username & password", Toast.LENGTH_SHORT).show()
                }
            }

        }


    }

    override fun onBackPressed() {
        var aleart=AlertDialog.Builder(this)
        aleart.setTitle("Are you Exit")

        aleart.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->
            finishAffinity()
        })
        aleart.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->
            dialogInterface.cancel()
        })
aleart.show()
    }
}