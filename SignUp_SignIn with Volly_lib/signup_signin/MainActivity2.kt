package com.example.signup_signin

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.signup_signin.databinding.ActivityMain2Binding
import com.example.signup_signin.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("User",Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("User",false) && !sharedPreferences.getString("mbl","")!!.isEmpty())
        {
            startActivity(Intent(applicationContext,MainActivity3::class.java))
        }

        binding.login.setOnClickListener {

            var mbl = binding.mobile.text.toString()
            var pass = binding.password.text.toString()

            var stringRequest:StringRequest = object:StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/login.php",{response ->
                try {
                    if (response.trim().equals("0"))
                    {
                        Toast.makeText(applicationContext, "LOGIN UNSUCCESSFULL", Toast.LENGTH_SHORT).show()
                    }
                    else
                    {
                        Toast.makeText(applicationContext, "LOGIN SUCCESSFULL", Toast.LENGTH_SHORT).show()
                        var editor: SharedPreferences.Editor= sharedPreferences.edit()
                        editor.putBoolean("User",true)
                        editor.putString("mbl",mbl)
                        editor.putString("pass",pass)
                        editor.commit()
                        startActivity(Intent(applicationContext,MainActivity3::class.java))
                    }
                }
                catch (e:Exception)
                {
                    e.printStackTrace()
                }
            },Response.ErrorListener{
                Toast.makeText(applicationContext, "LOGIN FAIL", Toast.LENGTH_SHORT).show()
            })
            {
                override fun getParams(): MutableMap<String, String>? {
                    var map = HashMap<String,String>()
                    map["mobile"]=mbl
                    map["password"]=pass
                    return map
                }
            }
            var queue : RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringRequest)
        }
        binding.signup.setOnClickListener {
            startActivity(Intent(applicationContext,MainActivity::class.java))
        }
    }
    override fun onBackPressed() {
        var aleart = AlertDialog.Builder(this)
        aleart.setTitle("Are you Exit")

        aleart.setPositiveButton("YES", { dialogInterface: DialogInterface, i: Int ->
            finishAffinity()
        })
        aleart.setNegativeButton("NO", { dialogInterface: DialogInterface, i: Int ->
            dialogInterface.cancel()
        })
        aleart.show()
    }
}