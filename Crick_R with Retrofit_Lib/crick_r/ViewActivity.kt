package com.example.crick_r

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crick_r.databinding.ActivityViewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewBinding
    lateinit var apiinterface: ApiInterface
    lateinit var list: MutableList<Modell>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        binding.recycler.layoutManager = layoutManager

        apiinterface = ApliClient.getapiclient().create(ApiInterface::class.java)

        var call: Call<List<Modell>> = apiinterface.viewdata()

        call.enqueue(object : Callback<List<Modell>> {
            override fun onResponse(call: Call<List<Modell>>, response: Response<List<Modell>>) {

                Toast.makeText(applicationContext, "WELCOME", Toast.LENGTH_SHORT).show()
                list = response.body() as MutableList<Modell>

                var adapter = MyAdapter(applicationContext, list)
                binding.recycler.adapter = adapter
            }


            override fun onFailure(call: Call<List<Modell>>, t: Throwable) {
                Toast.makeText(applicationContext, "NO INTERNET", Toast.LENGTH_SHORT).show()
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.lg -> {
                startActivity(Intent(applicationContext, MainActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
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
}
