package com.example.movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.TextSliderView

class MainActivity : AppCompatActivity() {

    lateinit var slider:SliderLayout
    lateinit var map:HashMap<String,Int>

    lateinit var gridView: GridView
    lateinit var list: MutableList<Model>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        slider=findViewById(R.id.slide)
        map = HashMap<String,Int>()
        gridView=findViewById(R.id.grid)

        map.put("a",R.drawable.yodha)
        map.put("b",R.drawable.rr)
        map.put("c",R.drawable.gadar)
        map.put("d",R.drawable.omg)
        map.put("e",R.drawable.fukry)
        map.put("f",R.drawable.jawan)

        for (i in map.keys)
        {
            var textslider=TextSliderView(this)
            textslider.description(i)
            textslider.image(map.get(i)!!)

            slider.addSlider(textslider)
            slider.setPresetTransformer(SliderLayout.Transformer.Default)
        }



        gridView=findViewById(R.id.grid)
        list=ArrayList()

        list.add(Model(R.drawable.y,"YODHA","RELEASE DATE","07 jul 2023","DIRECTED BY"," Sagar Ambre\n Pushkar Ojha","WRITTEN BY","Sagar Ambre","PRODUCED BY"," Hiroo Yash Johar\n Karan JOhar\n Apoorva Mehta\n Shashank khaitan","STARRING"," Sidharth Malhotra\n Disha patani\n Raashi Khanna","COUNTRY","India","LANGUAGE","Hindi","BUDGET","₹80-100 Crore"))
        list.add(Model(R.drawable.r,"ROCKY & RANI KI PREM KAHANI","RELEASE DATE","28 jul 2023","DIRECTED BY","Karan Johar","WRITTEN BY"," Ishita Moitra\n Shashankn Khaitan\n Sumit Roy","PRODUCED BY"," Hiroo Yash Johar\n Karan JOhar\n Apoorva Mehta\n Shashank khaitan","STARRING"," Dharmendra\nJaya Bachchan\n Shabana Azmi\n Ranveer Singh\n Alia Bhatt","COUNTRY","India","LANGUAGE","Hindi","BUDGET","₹60-70 Crore"))
        list.add(Model(R.drawable.g,"GADAR 2","RELEASE DATE","11 aug 2023","DIRECTED BY","Anil Sharma","WRITTEN BY","Shaktimaan Talwar","PRODUCED BY","Anil sharma","STARRING"," Sunny Deol\n Ameesha Patel\n Utkarsh Sharma\n Simrat kaur","COUNTRY","India","LANGUAGE","Hindi","BUDGET","est.₹100 Crore"))
        list.add(Model(R.drawable.o,"OMG","RELEASE DATE","11 aug 2023","DIRECTED BY","Amit Rai","WRITTEN BY","Amit Rai","PRODUCED BY"," Aruna Bhatia\n Vipul Shah\n Rajesh Bahi\n Ashwin Varde","STARRING","Akshay Kumar\n Pankaj Tripathi\n Yami Gautam Dhar\n Govind Namdev\n Arun Govil","COUNTRY","India","LANGUAGE","Hindi","BUDGET","₹150 Crore"))
        list.add(Model(R.drawable.j,"JAWAN","RELEASE DATE","07 sep 2023","DIRECTED BY","Atlee","WRITTEN BY"," Atlee\n S.Ramana Girivasan","PRODUCED BY"," Gauri Khan\n Gaurav Verma","STARRING"," Shahrukh Khan\n Nayanthara\n Vijay Sethupathi","COUNTRY","India","LANGUAGE","Hindi","BUDGET","₹150 Crore"))
        list.add(Model(R.drawable.f,"FUKRY 3","RELEASE DATE","01 dec 2023","DIRECTED BY","Mrighdeep lamba","WRITTEN BY","Vipul Vig","PRODUCED BY"," Farhan akhtar\n Ritesh Sidhwani","STARRING"," Ali Fazal\n Pankaj Tripathi\n Farhan Akhtar\n Naveen signh\n Richa Chadha\n Parth Siddhpura\n Pulkit Samrat\n Manjot Singh\n Varun Sharma\n Ritesh Sidhwani\n Akshay Sontakke\n santosh Singh","COUNTRY","India","LANGUAGE","Hindi","BUDGET  :  ","₹200-220 Crore"))

        var adapter=MyAdapter(applicationContext,list)
        gridView.adapter=adapter


        gridView.setOnItemClickListener { adapterView, view, i, l ->
 /*          Toast.makeText(applicationContext, ""+i, Toast.LENGTH_SHORT).show()*/

            var a = Intent(applicationContext,MainActivity2::class.java)
            a.putExtra("photos",list.get(i).img)
            a.putExtra("t1", list.get(i).name)
            a.putExtra("t2", list.get(i).date)
            a.putExtra("t3", list.get(i).directed)
            a.putExtra("t4", list.get(i).written)
            a.putExtra("t5", list.get(i).produced)
            a.putExtra("t6", list.get(i).star)
            a.putExtra("t7", list.get(i).country)
            a.putExtra("t8", list.get(i).lang)
            a.putExtra("t9", list.get(i).budge)

            a.putExtra("t10", list.get(i).a1)
            a.putExtra("t11", list.get(i).a2)
            a.putExtra("t12", list.get(i).a3)
            a.putExtra("t13", list.get(i).a4)
            a.putExtra("t14", list.get(i).a5)
            a.putExtra("t15", list.get(i).a6)
            a.putExtra("t16", list.get(i).a7)
            a.putExtra("t17", list.get(i).a8)





            //a.putExtra("pos", i)
            startActivity(a)



        }


    }
}