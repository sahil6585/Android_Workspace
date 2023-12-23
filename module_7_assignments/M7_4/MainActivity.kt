package com.example.song_from_server

import android.annotation.SuppressLint
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var play : ImageButton
    private lateinit var pause :ImageButton
    private lateinit var mediaPlayer: MediaPlayer
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        play = findViewById(R.id.play)
        pause = findViewById(R.id.pause)
        mediaPlayer = MediaPlayer()


        play.setOnClickListener {

            var audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"


            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)


            try {

                mediaPlayer.setDataSource(audioUrl)


                mediaPlayer.prepare()


                mediaPlayer.start()

            } catch (e: Exception) {


                e.printStackTrace()
            }

            Toast.makeText(applicationContext, "Audio started playing..", Toast.LENGTH_SHORT).show()
        }
        pause.setOnClickListener {

            if (mediaPlayer.isPlaying) {

                mediaPlayer.stop()

                mediaPlayer.reset()


                mediaPlayer.release()


                Toast.makeText(applicationContext, "Audio has been  paused..", Toast.LENGTH_SHORT)
                    .show()

            } else {

                Toast.makeText(applicationContext, "Audio not played..", Toast.LENGTH_SHORT).show()
            }

        }

    }

}
