package com.example.crick_r

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.crick_r.databinding.ActivityMainBinding
import com.example.crick_r.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    lateinit var apiinterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apiinterface = ApliClient.getapiclient().create(ApiInterface::class.java)

        binding.signup.setOnClickListener {

            var username = binding.username.text.toString()
            var mobile = binding.mobile.text.toString()
            var pass = binding.pass.text.toString()
            var location = binding.location.text.toString()

            var call: Call<Void> = apiinterface.registerdata(mobile, location, pass, username)

            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(applicationContext, "SIGN_UP SUCCESS", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "SIGN_UP FAIL", Toast.LENGTH_SHORT).show()

                }
            })
        }
        binding.signin.setOnClickListener {
            startActivity(Intent(applicationContext, LoginActivity::class.java))
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