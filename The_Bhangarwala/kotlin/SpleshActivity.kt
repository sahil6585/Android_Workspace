package com.example.thebhangarwala

import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast

class SpleshActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splesh)

        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        val connected = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)!!
            .state == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)!!.state == NetworkInfo.State.CONNECTED

        if(connected)
        {
            Handler().postDelayed(Runnable {

                var i= Intent(applicationContext,MainActivity::class.java)
                startActivity(i)

            },5000)
        }
        else
        {
            var layout= LayoutInflater.from(applicationContext)
            var view=layout.inflate(R.layout.design,null)
            var t1= Toast(applicationContext)
            t1.view=view
            t1.duration= Toast.LENGTH_LONG
            t1.show()
        }

    }
}