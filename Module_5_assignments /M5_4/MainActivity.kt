package com.example.signup_signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.signup_signin.databinding.ActivityMainBinding
import java.util.Objects

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.signup.setOnClickListener {

            var fname = binding.fname.text.toString()
            var lname = binding.lname.text.toString()
            var email = binding.email.text.toString()
            var mbl = binding.mbl.text.toString()
            var pass = binding.pass.text.toString()


            var StringRequest: StringRequest = object : StringRequest(Request.Method.POST, "https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/register.php", Response.Listener {

                    Toast.makeText(applicationContext, "Sign UP successfull", Toast.LENGTH_SHORT).show()
                },
                Response.ErrorListener {
                    Toast.makeText(applicationContext, "NO INTERNET", Toast.LENGTH_SHORT).show()
                })
            {
                override fun getParams(): MutableMap<String, String>? {

                    var map = HashMap<String,String>()
                        map["firstname"]=fname
                        map["lastname"]=lname
                        map["email"]=email
                        map["mobile"]=mbl
                        map["password"]=pass
                    return map
                }
            }
            var queue : RequestQueue = Volley.newRequestQueue(this)
            queue.add(StringRequest)
        }
        binding.signin.setOnClickListener {

            var Intent = Intent(applicationContext,MainActivity2::class.java)
            startActivity(Intent)
        }



    }
}