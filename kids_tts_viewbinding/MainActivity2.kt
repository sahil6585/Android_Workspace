package com.example.kids

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.QUEUE_ADD
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.kids.databinding.ActivityMain2Binding
import com.example.kids.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.security.Permission
import java.util.Locale

class MainActivity2 : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var binding: ActivityMain2Binding
    lateinit var list: MutableList<Modell>
    lateinit var tts:TextToSpeech


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        tts = TextToSpeech(applicationContext,this)
     /*   if (checkSelfPermission(AUDIO_SERVICE)!=PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(AUDIO_SERVICE),101)
        }
*/
        list = ArrayList()

        list.add(
            Modell(
                R.drawable.animals,
                "ANIMALS",
                R.drawable.liion,
                "LION",
                R.drawable.tiger,
                "TIGER",
                R.drawable.elephant,
                "ELEPHANT",
                R.drawable.bear,
                "BEAR",
                R.drawable.horse,
                "HORSE",
                R.drawable.monkey,
                "MONKEY",
                R.drawable.panda,
                "PANDA",
                R.drawable.rhinoceros,
                "RHINOCEROS",
                R.drawable.fox,
                "FOX"
            )
        )
        list.add(
            Modell(
                R.drawable.birds,
                "BIRDS",
                R.drawable.parrot,
                "PARROT",
                R.drawable.peacock,
                "PEACOCK",
                R.drawable.pigeon,
                "PIGEON",
                R.drawable.hen,
                "HEN",
                R.drawable.hornbill,
                "HORNBILL",
                R.drawable.hummingbird,
                "HUMMINGBIRD",
                R.drawable.kingfisher,
                "KINGFISHER",
                R.drawable.eagle,
                "EAGLE",
                R.drawable.duck,
                "DUCK"
            )
        )
        list.add(
            Modell(
                R.drawable.fruits,
                "FRUITS",
                R.drawable.mango,
                "MANGO",
                R.drawable.graps,
                "GRAPES",
                R.drawable.banana,
                "BANANA",
                R.drawable.guava,
                "GUAVA",
                R.drawable.apple,
                "APPLE",
                R.drawable.kiwi,
                "KIWI",
                R.drawable.orange,
                "ORANGE",
                R.drawable.strawberry,
                "STRAWBERRY",
                R.drawable.avocado,
                "AVOCADO"
            )
        )
        list.add(
            Modell(
                R.drawable.colors,
                "COLORS",
                R.drawable.red,
                "RED",
                R.drawable.green,
                "GREEN",
                R.drawable.purple,
                "PURPLE",
                R.drawable.yellow,
                "YELLOW",
                R.drawable.pink,
                "PINK",
                R.drawable.black,
                "BLACK",
                R.drawable.white,
                "WHITE",
                R.drawable.ornagec,
                "ORANGE",
                R.drawable.blue,
                "BLUE"
            )
        )
        var adapter = Myadapter(applicationContext, list)
        binding.grid.adapter = adapter

        binding.grid.setOnItemClickListener { adapterView, view, i, l ->

            // Toast.makeText(applicationContext, ""+i, Toast.LENGTH_SHORT).show()

          var data = list.get(i).name
          tts.speak(data,QUEUE_ADD,null)

          Thread.sleep(1000)

            var n = Intent(applicationContext, Animal::class.java)

            n.putExtra("ph1", list.get(i).p1)
            n.putExtra("nm1", list.get(i).n1)
            n.putExtra("ph2", list.get(i).p2)
            n.putExtra("nm2", list.get(i).n2)
            n.putExtra("ph3", list.get(i).p3)
            n.putExtra("nm3", list.get(i).n3)
            n.putExtra("ph4", list.get(i).p4)
            n.putExtra("nm4", list.get(i).n4)
            n.putExtra("ph5", list.get(i).p5)
            n.putExtra("nm5", list.get(i).n5)
            n.putExtra("ph6", list.get(i).p6)
            n.putExtra("nm6", list.get(i).n6)
            n.putExtra("ph7", list.get(i).p7)
            n.putExtra("nm7", list.get(i).n7)
            n.putExtra("ph8", list.get(i).p8)
            n.putExtra("nm8", list.get(i).n8)
            n.putExtra("ph9", list.get(i).p9)
            n.putExtra("nm9", list.get(i).n9)



            startActivity(n)
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

    override fun onInit(p0: Int) {

        tts.setLanguage(Locale.UK)
        tts.setPitch(0.9F)
        tts.setSpeechRate(0.9F)
    }
}