package com.example.crick_d

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.crick_d.databinding.ActivityInsertBinding

class InsertActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInsertBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.insert.setOnClickListener {

            var cricketerName = binding.cricketerName.text.toString()
            var cricketerWickets = binding.cricketerWickets.text.toString()
            var cricketerAge = binding.cricketerAge.text.toString()
            var cricketerHighestScore = binding.cricketerHighestScore.text.toString()
            var cricketerTotalScore = binding.cricketerTotalScore.text.toString()

            var StringRequest: StringRequest = object : StringRequest(
                Request.Method.POST, "https://sahiltops3939.000webhostapp.com/API/Data/insert.php",
                Response.Listener {
                    Toast.makeText(
                        applicationContext,
                        "Record Insert Successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                Response.ErrorListener {
                    Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_SHORT).show()
                }) {
                override fun getParams(): MutableMap<String, String>? {
                    var map = HashMap<String, String>()
                    map["cricketer_name"] = cricketerName
                    map["cricketer_wickets"] = cricketerWickets
                    map["cricketer_age"] = cricketerAge
                    map["cricketer_highest_score"] = cricketerHighestScore
                    map["cricketer_total_score"] = cricketerTotalScore
                    return map
                }
            }
            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(StringRequest)
        }
    }

    override fun onBackPressed() {
        var aleart = AlertDialog.Builder(this)
        aleart.setTitle(" SELECT ONE ")


        aleart.setPositiveButton("INFO", { dialogInterface: DialogInterface, i: Int ->
            startActivity(Intent(applicationContext, ViewActivity::class.java))
        })
        aleart.setNegativeButton("NO", { dialogInterface: DialogInterface, i: Int ->
            dialogInterface.cancel()
        })
        aleart.show()
    }
}
