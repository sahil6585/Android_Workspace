package com.example.crick_r

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.crick_r.databinding.ActivityMainBinding
import com.example.crick_r.databinding.ActivityUpdateBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    lateinit var apiinterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i=intent

        var id = i.getIntExtra("id", 101)
        var name = i.getStringExtra("name")
        var age = i.getStringExtra("age")
        var tscore = i.getStringExtra("totalscore")
        var hscore = i.getStringExtra("highestscore")
        var wickets = i.getStringExtra("wickets")

        binding.cricketerName.setText(name)
        binding.cricketerAge.setText(age)
        binding.cricketerTotalScore.setText(tscore)
        binding.cricketerHighestScore.setText(hscore)
        binding.cricketerWickets.setText(wickets)


        apiinterface = ApliClient.getapiclient().create(ApiInterface::class.java)

        binding.update.setOnClickListener {

            var namee = binding.cricketerName.text.toString()
            var agee = binding.cricketerAge.text.toString()
            var scoret = binding.cricketerTotalScore.text.toString()

            var scoreh = binding.cricketerHighestScore.text.toString()
            var wicket = binding.cricketerWickets.text.toString()

            var call: Call<Void> = apiinterface.updatedata(id, namee,wicket,agee,scoreh,scoret)

            call.enqueue(object:Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(applicationContext,"Updated", Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,ViewActivity::class.java))
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext,"Fail",Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}