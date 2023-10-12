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
import com.example.crick_d.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        var id = i.getIntExtra("id", 101)
        var name = i.getStringExtra("name")
        var age = i.getStringExtra("age")
        var tscore = i.getStringExtra("totalscore")
        var hscore = i.getStringExtra("highestscore")
        var wickets = i.getStringExtra("wickets")

        binding.cricketerName.setText(name)
        binding.cricketerAge.setText(age)
        binding.cricketerTotalScore.setText(tscore)
        binding.cricketerHighestScore.setText(hscore)
        binding.cricketerWickets.setText(wickets)
        binding.update.setOnClickListener {

            var name = binding.cricketerName.text.toString()
            var age = binding.cricketerAge.text.toString()
            var tscore = binding.cricketerTotalScore.text.toString()

            var hscore = binding.cricketerHighestScore.text.toString()
            var wickets = binding.cricketerWickets.text.toString()

            var stringRequest: StringRequest = object : StringRequest(
                Request.Method.POST,
                "https://sahiltops3939.000webhostapp.com/API/Data/update.php",
                Response.Listener {

                    Toast.makeText(applicationContext, "Record Updated", Toast.LENGTH_LONG).show()
                    var i = Intent(applicationContext,ViewActivity::class.java)
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(i)
                },
                Response.ErrorListener {

                    Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG).show()

                }) {
                override fun getParams(): MutableMap<String, String>? {
                    var map = HashMap<String, String>()
                    map["id"] = id.toString()
                    map["cricketer_name"] = name
                    map["cricketer_age"] = age
                    map["cricketer_wickets"] = wickets
                    map["cricketer_total_score"] = tscore
                    map["cricketer_highest_score"] = hscore


                    return map
                }
            }

            var queue: RequestQueue = Volley.newRequestQueue(applicationContext)
            queue.add(stringRequest)


        }
    }
}