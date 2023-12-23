package com.example.textintospeech

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var Text: EditText
    private lateinit  var btnText: Button
    private lateinit  var textToSpeech: TextToSpeech
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Text = findViewById(R.id.Text)
        btnText = findViewById(R.id.btnText)
        textToSpeech = TextToSpeech(
            applicationContext
        ) { i ->
            if (i != TextToSpeech.ERROR) {

                textToSpeech.language = Locale.UK
            }
        }


        btnText.setOnClickListener {
            textToSpeech.speak(
                Text.text.toString(), TextToSpeech.QUEUE_FLUSH, null
            )
        }
    }
}