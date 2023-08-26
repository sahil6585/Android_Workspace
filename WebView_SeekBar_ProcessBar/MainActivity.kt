package com.example.webview_seekbar_processbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.example.webview_seekbar_processbar.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.b1.setOnClickListener {
            binding.process.incrementProgressBy(1)
            setProgress(100* binding.process.progress)
        }
        binding.b2.setOnClickListener {
            binding.process.incrementProgressBy(-1)
            setProgress(100* binding.process.progress)
        }

        binding.s1.setOnSeekBarChangeListener(this)
        binding.s2.setOnSeekBarChangeListener(this)
        binding.s3.setOnSeekBarChangeListener(this)

        binding.web.loadUrl("https://www.google.com")
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        var a= binding.s1.progress
        var b= binding.s2.progress
        var c= binding.s3.progress
        binding.img.setBackgroundColor(Color.rgb(a,b,c))
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }

}