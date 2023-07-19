package com.example.foodzone

import android.Manifest.permission.CALL_PHONE
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

lateinit var txt1:TextView
lateinit var txt2:TextView
lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt1=findViewById(R.id.t2)
        txt2=findViewById(R.id.t4)
        btn1=findViewById(R.id.b1)

        btn1.setOnClickListener{

            var name =txt1.text.toString()
            var pass =txt2.text.toString()

            if (name.length == 0 && pass.length == 0)
            {
                txt1.setError("Please enter a name")
                txt2.setError("Please enter a password")
            }
            else if (name.length == 0)
            {
                txt1.setError("Please enter a name")
            }
            else if (pass.length == 0)
            {
                txt2.setError("Please enter a password")
            }
            else
            {

                if(name.equals("sahil") && name.equals("SAHIL") && name.equals("Sahil") )
                {
                    txt1.setError("Wrong Username")
                }
                else if ( pass.equals("sahil39"))
                {
                    Toast.makeText(applicationContext, "LOGIN SUCCESSFULLY", Toast.LENGTH_SHORT)
                        .show()
                    var i = Intent(applicationContext, MainActivity2::class.java)
                    i.putExtra("FOOD", name)
                    startActivity(i)
                }
                else
                {
                    Toast.makeText(this, "Wrong User", Toast.LENGTH_SHORT).show()
                }

            }
        }
        if(checkSelfPermission(CALL_PHONE)!=PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(CALL_PHONE),101)
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
