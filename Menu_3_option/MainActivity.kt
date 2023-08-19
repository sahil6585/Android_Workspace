package com.example.menu_3_option

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import android.widget.Toast
import com.example.menu_3_option.databinding.ActivityMainBinding
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var listview:MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        listview=ArrayList()
        listview.add("Sahil")
        listview.add("Jaimin")
        listview.add("Yaksh")
        listview.add("Jayraj")

        var arrayadapter=ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,listview)
        binding.list.adapter=arrayadapter
        registerForContextMenu(binding.list)

        //binding.list.setOnItemLongClickListener(this)
///popup menu===========================================================================
binding.b.setOnClickListener {
        var p =PopupMenu(applicationContext,binding.b)
        p.menuInflater.inflate(R.menu.popup_menu,p.menu)
        p.setOnMenuItemClickListener(this)
        p.show()
        }
    }


///option menu============================================================================
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.lg ->
            {
                Toast.makeText(applicationContext, "LOGOUT", Toast.LENGTH_SHORT).show()
                Thread.sleep(1000)
                finishAffinity()
            }
        }
        return super.onOptionsItemSelected(item)
    }
 ///======================================================================================

///context menu===========================================================================

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menuInflater.inflate(R.menu.context_menu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        var a: AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var pos=a.position
        when(item.itemId)
        {
            R.id.i1->
            {
                Toast.makeText(applicationContext, ""+pos, Toast.LENGTH_SHORT).show()
            }
        }
        return super.onContextItemSelected(item)
    }
    ///======================================================================================

    ///popup menu fun======================================================================================
    override fun onMenuItemClick(p0: MenuItem?): Boolean {
      when (p0!!.itemId)
      {
          R.id.p->
          {
              Toast.makeText(applicationContext, "click", Toast.LENGTH_SHORT).show()
          }
      }
        return false
    }


/////////////////////////////////////////////////////////////////////////////////////////////
 /*   override fun onItemLongClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long): Boolean
    {
        Toast.makeText(applicationContext, "helloo", Toast.LENGTH_SHORT).show()
        return false
    }*/
    ///======================================================================================


}