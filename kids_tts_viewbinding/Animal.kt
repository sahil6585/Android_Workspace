package com.example.kids

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.QUEUE_ADD
import android.widget.Toast
import com.example.kids.databinding.ActivityAnimalBinding
import com.example.kids.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Locale

class Animal : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var binding: ActivityAnimalBinding
lateinit var spe:TextToSpeech



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAnimalBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


       Toast.makeText(applicationContext, "click only images", Toast.LENGTH_SHORT).show()

        spe= TextToSpeech(applicationContext,this)


        var n=intent
        binding.i1.setImageResource(n.getIntExtra("ph1",101))
        binding.txt1.setText(n.getStringExtra("nm1"))
        binding.i2.setImageResource(n.getIntExtra("ph2",101))
        binding.txt2.setText(n.getStringExtra("nm2"))
        binding.i3.setImageResource(n.getIntExtra("ph3",101))
        binding.txt3.setText(n.getStringExtra("nm3"))
        binding.i4.setImageResource(n.getIntExtra("ph4",101))
        binding.txt4.setText(n.getStringExtra("nm4"))
        binding.i5.setImageResource(n.getIntExtra("ph5",101))
        binding.txt5.setText(n.getStringExtra("nm5"))
        binding.i6.setImageResource(n.getIntExtra("ph6",101))
        binding.txt6.setText(n.getStringExtra("nm6"))
        binding.i7.setImageResource(n.getIntExtra("ph7",101))
        binding.txt7.setText(n.getStringExtra("nm7"))
        binding.i8.setImageResource(n.getIntExtra("ph8",101))
        binding.txt8.setText(n.getStringExtra("nm8"))
        binding.i9.setImageResource(n.getIntExtra("ph9",101))
        binding.txt9.setText(n.getStringExtra("nm9"))



        binding.i1.setOnClickListener {

            var s1=binding.txt1.text.toString()
            spe.speak(s1,QUEUE_ADD,null,null)
        }
        binding.i2.setOnClickListener {

            var s2=binding.txt2.text.toString()
            spe.speak(s2,QUEUE_ADD,null,null)
        }
        binding.i3.setOnClickListener {

            var s3=binding.txt3.text.toString()
            spe.speak(s3,QUEUE_ADD,null,null)
        }
        binding.i4.setOnClickListener {

            var s4=binding.txt4.text.toString()
            spe.speak(s4,QUEUE_ADD,null,null)
        }
        binding.i5.setOnClickListener {

            var s5=binding.txt5.text.toString()
            spe.speak(s5,QUEUE_ADD,null,null)
        }
        binding.i6.setOnClickListener {

            var s6=binding.txt6.text.toString()
            spe.speak(s6,QUEUE_ADD,null,null)
        }
        binding.i7.setOnClickListener {

            var s7=binding.txt7.text.toString()
            spe.speak(s7,QUEUE_ADD,null,null)
        }
        binding.i8.setOnClickListener {

            var s8=binding.txt8.text.toString()
            spe.speak(s8,QUEUE_ADD,null,null)
        }
        binding.i9.setOnClickListener {

            var s9=binding.txt9.text.toString()
            spe.speak(s9,QUEUE_ADD,null,null)
        }




    }
    override fun onInit(p0: Int) {
       spe.setLanguage(Locale.UK)
        spe.setPitch(0.9f)
        spe.setSpeechRate(0.9f)
    }
}