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
import com.example.signup_signin.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {
    private lateinit var binding: ActivityMain5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        var id = i.getIntExtra("myid", 101)
        var name = i.getStringExtra("myname")
        var price = i.getStringExtra("myprice")
        var des = i.getStringExtra("mydes")

        binding.edtpname.setText(name)
        binding.edtpprice.setText(price)
        binding.edtdes.setText(des)

        binding.update.setOnClickListener {

            var name = binding.edtpname.text.toString()
            var price = binding.edtpprice.text.toString()
            var des = binding.edtdes.text.toString()

            var stringRequest: StringRequest = object : StringRequest(
                Request.Method.POST,
                "https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/productupdate.php",
                Response.Listener {

                    Toast.makeText(applicationContext, "Product Updated", Toast.LENGTH_LONG).show()
                    var i = Intent(applicationContext, MainActivity3::class.java)
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(i)
                },
                Response.ErrorListener {

                    Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG).show()

                }) {
                override fun getParams(): MutableMap<String, String>? {
                    var map = HashMap<String, String>()
                    map["product_id"] = id.toString()
                    map["product_name"] = name
                    map["product_price"] = price
                    map["product_description"] = des


                    return map
                }
            }

            var queue: RequestQueue = Volley.newRequestQueue(applicationContext)
            queue.add(stringRequest)


        }
    }
}