package com.example.audio

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

        lateinit var button: Button
        lateinit var button2:Button
        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            button = findViewById(R.id.btnPlayAudio)
            button2 = findViewById(R.id.btnPauseAudio)

            val ring: MediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.animalranbir)

            button.setOnClickListener {



                ring.start()


            }

            button2.setOnClickListener {

                ring.pause()


            }
        }
    }
