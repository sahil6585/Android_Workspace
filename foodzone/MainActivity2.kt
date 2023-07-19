package com.example.foodzone

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity() {

    lateinit var t1:TextView
    lateinit var c1:CheckBox
    lateinit var c2:CheckBox
    lateinit var c3:CheckBox
    lateinit var c4:CheckBox
    lateinit var b1:Button
    lateinit var i1:ImageView
    lateinit var i2:ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        t1=findViewById(R.id.txt1)
        c1=findViewById(R.id.txt2)
        c2=findViewById(R.id.txt3)
        c3=findViewById(R.id.txt4)
        c4=findViewById(R.id.txt5)
        b1=findViewById(R.id.btn2)
        i1=findViewById(R.id.call)
        i2=findViewById(R.id.fb)

        var a1=intent
        t1.setText(" welcome: "+a1.getStringExtra("FOOD"))

        b1.setOnClickListener {


            var amount=0
            var builder=StringBuilder("SELECTED ITEM \n\n")

            if (c1.isChecked)
            {
                builder.append("Burger rs:90\n")
                amount+=90
            }
            if (c2.isChecked)
            {
                builder.append("French Fries rs:60\n")
                amount+=60
            }
            if (c3.isChecked)
            {
                builder.append("Pizza rs:170\n")
                amount+=170
            }
            if (c4.isChecked)
            {
                builder.append("Popcorn rs:50\n")
                amount+=50
            }
            builder.append("\nTOTAL AMOUNT : "+amount)

            var i = Intent(applicationContext,MainActivity3::class.java)
            i.putExtra("bill",builder.toString())
            startActivity(i)


        }

        i1.setOnClickListener {
            var num="12345678"
            var i=Intent(Intent.ACTION_CALL)
            i.setData(Uri.parse("tel:"+num))
            startActivity(i)
        }

        i2.setOnClickListener {
            var i=Intent(applicationContext,MainActivity4::class.java)
            startActivity(i)
        }
    }

    override fun onBackPressed() {
        var alert = AlertDialog.Builder(this)
        alert.setTitle("ARE YOU EXIT ?")

        alert.setPositiveButton("YES", { dialogInterface: DialogInterface, i: Int ->
            finishAffinity()
        })
        alert.setNegativeButton("NO", { dialogInterface: DialogInterface, i: Int ->
            dialogInterface.cancel()
        })
        alert.show()
    }
}