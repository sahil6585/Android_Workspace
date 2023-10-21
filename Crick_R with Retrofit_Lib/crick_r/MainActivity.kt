package com.example.crick_r

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.crick_r.databinding.ActivityMainBinding
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var apiinterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apiinterface=ApliClient.getapiclient().create(ApiInterface::class.java)

        binding.insert.setOnClickListener {
            var cricketerName = binding.cricketerName.text.toString()
            var cricketerWickets = binding.cricketerWickets.text.toString()
            var cricketerAge = binding.cricketerAge.text.toString()
            var cricketerHighestScore = binding.cricketerHighestScore.text.toString()
            var cricketerTotalScore = binding.cricketerTotalScore.text.toString()

            var call :retrofit2.Call<Void> = apiinterface.insertdata(cricketerName,cricketerAge,cricketerWickets,cricketerHighestScore,cricketerTotalScore)

            call.enqueue(object :retrofit2.Callback<Void>{
                override fun onResponse(call: retrofit2.Call<Void>, response: Response<Void>) {
                    Toast.makeText(applicationContext, "insreted", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: retrofit2.Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "fail", Toast.LENGTH_SHORT).show()
                }
            })
        }
        binding.view.setOnClickListener {

            startActivity(Intent(applicationContext,ViewActivity::class.java))

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