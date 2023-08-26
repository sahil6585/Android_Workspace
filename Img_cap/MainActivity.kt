package com.example.img_cap

import android.Manifest.permission.CAMERA
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.widget.Toast
import com.example.img_cap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if(checkSelfPermission(CAMERA)!=PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(CAMERA),101)
        }

    binding.click.setOnClickListener {
        var i=Intent(ACTION_IMAGE_CAPTURE)
        startActivityForResult(i,1)
    }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //..
        // Toast.makeText(applicationContext,""+requestCode,Toast.LENGTH_LONG).show()
        if (requestCode==1 && resultCode== RESULT_OK)
        {
            var bm:Bitmap= data!!.extras!!.get("data") as Bitmap
            binding.img.setImageBitmap(bm)
        }
        //super.onActivityResult(requestCode, resultCode, data)
    }
}