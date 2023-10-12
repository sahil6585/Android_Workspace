package com.example.crick_d

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.crick_d.databinding.ActivityViewBinding
import org.json.JSONArray
import java.lang.Exception

class ViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewBinding
    lateinit var list : MutableList<Modell>
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE)
        list = ArrayList()
        Toast.makeText(
            applicationContext,
            "Welcome " + sharedPreferences.getString("mbl", ""),
            Toast.LENGTH_LONG
        ).show()

        var manager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager = manager

          var StringRequest = StringRequest(
            Request.Method.POST,"https://sahiltops3939.000webhostapp.com/API/Data/view.php",{ Response ->

            try {
                var jsonArray = JSONArray(Response)
                for (i in 0 until jsonArray.length()) {
                    var jsonObject = jsonArray.getJSONObject(i)
                    var id = jsonObject.getInt("id")
                    var cname = jsonObject.getString("cricketer_name")
                    var ctscore = jsonObject.getString("cricketer_total_score")
                    var cage = jsonObject.getString("cricketer_age")
                    var cscore = jsonObject.getString("cricketer_highest_score")
                    var cwickets = jsonObject.getString("cricketer_wickets")


                    var m = Modell()
                    m.id = id
                    m.cricketer_name=cname
                   m.cricketer_total_score =ctscore
                   m.cricketer_age = cage
                   m.cricketer_highest_score=cscore
                   m.cricketer_wickets=cwickets
                    list.add(m)
                }
            }
            catch (e: Exception)
            {
                e.printStackTrace()
            }
            var myadapter = MyAdapter(applicationContext,list)
            binding.recycler.adapter=myadapter
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
                startActivity(Intent(applicationContext,InsertActivity::class.java))
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
