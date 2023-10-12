package com.example.signup_signin

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.signup_signin.databinding.ActivityMain4Binding
import com.example.signup_signin.databinding.ActivityMainBinding

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.enter.setOnClickListener {

            var name=binding.name.text.toString()
            var price=binding.price.text.toString()
            var dis = binding.dis.text.toString()

            var StringRequest : StringRequest = object :StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/productinsert.php",Response.Listener {

                Toast.makeText(applicationContext, "Record Insert Successfully", Toast.LENGTH_SHORT).show()
            },Response.ErrorListener {
                Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_SHORT).show()
            })
            {
                override fun getParams(): MutableMap<String, String>? {
                    var map=HashMap<String,String>()
                    map["product_name"]=name
                    map["product_price"]=price
                    map["product_description"]=dis

                    return map
                }
            }
            var queue : RequestQueue = Volley.newRequestQueue(this)
            queue.add(StringRequest)
        }
    }
    override fun onBackPressed() {
        var aleart = AlertDialog.Builder(this)
        aleart.setTitle(" SELECT ONE ")


        aleart.setPositiveButton("PRODUCT", { dialogInterface: DialogInterface, i: Int ->
            startActivity(Intent(applicationContext,MainActivity3::class.java))
        })
        aleart.setNegativeButton("NO", { dialogInterface: DialogInterface, i: Int ->
            dialogInterface.cancel()
        })
        aleart.show()
    }
}