package com.example.crick_r

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.crick_r.databinding.ActivityLoginBinding
import com.example.crick_r.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    lateinit var apiinterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apiinterface = ApliClient.getapiclient().create(ApiInterface::class.java)

        binding.login.setOnClickListener {
            var mbl = binding.mobile.text.toString()
            var pass = binding.password.text.toString()

            var call: Call<RegisteerModel> = apiinterface.logindata(mbl, pass)

            call.enqueue(object : Callback<RegisteerModel> {
                override fun onResponse(
                    call: Call<RegisteerModel>,
                    response: Response<RegisteerModel>
                ) {
                    Toast.makeText(applicationContext, "LOGIN SUCESS", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(applicationContext, ViewActivity::class.java))
                }

                override fun onFailure(call: Call<RegisteerModel>, t: Throwable) {
                    Toast.makeText(applicationContext, "LOGIN FAIL", Toast.LENGTH_SHORT).show()
                }
            })
        }
        binding.signup.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterActivity::class.java))
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