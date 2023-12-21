package com.example.framebyframe

import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
lateinit var btn:Button
    lateinit var btn1:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ad = AnimationDrawable()
        imageView=findViewById(R.id.img)
        var f1 = resources.getDrawable(R.drawable.frame_1,null)
        var f2 = resources.getDrawable(R.drawable.frame_2,null)
        var f3 = resources.getDrawable(R.drawable.frame_3,null)
        var f4 = resources.getDrawable(R.drawable.frame_4,null)
        var f5 = resources.getDrawable(R.drawable.frame_5,null)
        var f6 = resources.getDrawable(R.drawable.frame_6,null)

        ad.addFrame(f1,200)
        ad.addFrame(f2,300)
        ad.addFrame(f3,400)
        ad.addFrame(f4,500)
        ad.addFrame(f5,600)
        ad.addFrame(f6,700)

        imageView.background=ad

        btn=findViewById(R.id.btn)
        btn1=findViewById(R.id.btn1)

        btn.setOnClickListener {
            ad.start()
        }
        btn1.setOnClickListener {
            ad.stop()
        }

    }
}