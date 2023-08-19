package com.example.amul

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {


    lateinit var im1: ImageView
    lateinit var im2: ImageView
    lateinit var im3: ImageView
    lateinit var im4: ImageView

    lateinit var t1: TextView
    lateinit var t2: TextView
    lateinit var t3: TextView
    lateinit var t4: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        im1=findViewById(R.id.i1)
        im2=findViewById(R.id.i2)
        im3=findViewById(R.id.i3)
        im4=findViewById(R.id.i4)

        t1=findViewById(R.id.t1)
        t2=findViewById(R.id.t2)
        t3=findViewById(R.id.t3)
        t4=findViewById(R.id.t4)

        im1.setOnClickListener {

            var i1=Intent(applicationContext,B_milkActivity2::class.java)
            startActivity(i1)

        }
        im2.setOnClickListener {

            var i2=Intent(applicationContext,Ice_Activity3::class.java)
            startActivity(i2)

        }
        im3.setOnClickListener {

            var i3=Intent(applicationContext,Butter_Activity3::class.java)
            startActivity(i3)

        }
        im4.setOnClickListener {

            var i4=Intent(applicationContext,Cheese_Activity4::class.java)
            startActivity(i4)

        }

        t1.setOnClickListener {
            var url="https://shop.amul.com/en/product/amul-high-protein-buttermilk-200-ml-or-pack-of-30"

            var i1=Intent(Intent.ACTION_VIEW)
            i1.setData(Uri.parse(url))
            startActivity(i1)
        }

        t2.setOnClickListener {
            var url="https://www.bigbasket.com/pd/40005430/amul-real-ice-cream-rajbhog-1-l-tub/"

            var i2=Intent(Intent.ACTION_VIEW)
            i2.setData(Uri.parse(url))
            startActivity(i2)
        }

        t3.setOnClickListener {
            var url="https://www.amazon.in/Amul-Butter-Blister-Pack-100/dp/B09VZH83BR/ref=sr_1_2?keywords=amul+butter&qid=1688629218&sr=8-2"

            var i3=Intent(Intent.ACTION_VIEW)
            i3.setData(Uri.parse(url))
            startActivity(i3)
        }

        t4.setOnClickListener {
            var url="https://www.amazon.in/Amul-Cheese-Easy-Open-Chiplet/dp/B0BQRPZSKT/ref=sr_1_8?crid=KH1VVVV7NIRD&keywords=amul+cheese&qid=1688629158&sprefix=ammul+cheese%2Caps%2C305&sr=8-8"

            var i4=Intent(Intent.ACTION_VIEW)
            i4.setData(Uri.parse(url))
            startActivity(i4)
        }







    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBackPressed()
    {

    var alert=AlertDialog.Builder(this)
       alert.setTitle("ARE YOU EXIT !!")

        alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->
            finishAffinity()
        })
        alert.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->
            dialogInterface.cancel()
        })
        alert.show()

    }
}