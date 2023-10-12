package com.example.signup_signin

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.signup_signin.databinding.ActivityMain2Binding
import com.example.signup_signin.databinding.ActivityMain3Binding
import org.json.JSONArray
import java.lang.Exception

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
   lateinit var list : MutableList<Modell>
   lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE)
        list=ArrayList()
        Toast.makeText(applicationContext,"Welcome "+sharedPreferences.getString("mbl",""),Toast.LENGTH_LONG).show()

        var manager:RecyclerView.LayoutManager = LinearLayoutManager(this)
       binding.recycler.layoutManager=manager

        var StringRequest = StringRequest(Request.Method.GET,"https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/productview.php",{Response ->

            try {
                var jsonArray = JSONArray(Response)

                for (i in 0 until jsonArray.length()) {
                    var jsonObject = jsonArray.getJSONObject(i)
                    var id = jsonObject.getInt("product_id")
                    var name = jsonObject.getString("product_name")
                    var price = jsonObject.getString("product_price")
                    var dis = jsonObject.getString("product_description")

                    var m = Modell()
                    m.product_id = id
                    m.product_name = name
                    m.product_price = price
                    m.product_description = dis
                    list.add(m)
                }
            }
            catch (e:Exception)
            {
                e.printStackTrace()
            }
            var myAdapter = MyAdapter(applicationContext,list)
            binding.recycler.adapter=myAdapter
        },
            {
                Toast.makeText(applicationContext, "NO INTERNET", Toast.LENGTH_SHORT).show()
            })

        var queue : RequestQueue = Volley.newRequestQueue(this)
        queue.add(StringRequest)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.add->
            {
                startActivity(Intent(applicationContext,MainActivity4::class.java))
            }
            R.id.lg->
            {
                sharedPreferences.edit().clear().commit()
                finish()
                startActivity(Intent(applicationContext,MainActivity::class.java))
            }
        }

        return super.onOptionsItemSelected(item)
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
