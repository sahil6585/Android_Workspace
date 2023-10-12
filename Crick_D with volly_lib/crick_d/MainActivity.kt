package com.example.crick_d

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.crick_d.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.signup.setOnClickListener {

            var username = binding.username.text.toString()
            var mobile = binding.mobile.text.toString()
            var pass = binding.pass.text.toString()
            var location = binding.location.text.toString()



            var StringRequest: StringRequest = object : StringRequest(
                Request.Method.POST, "https://sahiltops3939.000webhostapp.com/API/Data/register.php", Response.Listener {

                Toast.makeText(applicationContext, "Sign UP successfull", Toast.LENGTH_SHORT).show()
            },
                Response.ErrorListener {
                    Toast.makeText(applicationContext, "NO INTERNET", Toast.LENGTH_SHORT).show()
                })
            {
                override fun getParams(): MutableMap<String, String>? {

                    var map = HashMap<String,String>()
                    map["username"]=username
                    map["location"]=location
                    map["mobile"]=mobile
                    map["password"]=pass
                    return map
                }
            }
            var queue : RequestQueue = Volley.newRequestQueue(this)
            queue.add(StringRequest)
        }
        binding.signin.setOnClickListener {

            var Intent = Intent(applicationContext,LoginActivity::class.java)
            startActivity(Intent)
        }



    }
}