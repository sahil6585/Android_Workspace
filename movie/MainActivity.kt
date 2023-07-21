package com.example.whatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display.Mode
import android.widget.Adapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var listview:ListView
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listview=findViewById(R.id.list)
        list=ArrayList()


        list.add(Model(1,R.drawable.insta,"Instagram","Social・Networking","Installed"))
        list.add(Model(2,R.drawable.wh,"WhatsApp Messsenger","Communication・Messaging","Installed"))
        list.add(Model(3,R.drawable.phonepe,"PhonePe UPI,Payment,Recharge","Finance・Mobile payments","Installed"))
        list.add(Model(4,R.drawable.snap,"Snapchat","Comunication・Social・Networking","Installed"))
        list.add(Model(5,R.drawable.flip,"Flipkart Online Shopping App","Shopping・Online marketplace","Installed"))
        list.add(Model(6,R.drawable.fb,"Facebook","Social・Networking","Installed"))
        list.add(Model(7,R.drawable.meessho,"Meesho: Online Shopping App","Shopping・Online marketplace","Installed"))
        list.add(Model(8,R.drawable.threads,"Threads,an Instagram app","Social","Installed"))


var adapter=MyAdapter(applicationContext,list)
        listview.adapter=adapter

    }
}