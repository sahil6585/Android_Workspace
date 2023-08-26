package com.example.sqlite_1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build.VERSION

class DbHelper(context: Context): SQLiteOpenHelper(context, DB_NAME,null, VERSION)
{
    companion object
    {
        var DB_NAME="MyData.db"
        var TABLE_NAME="Info"
        var ID="Id"
        var NAME="Name"
        var NUMBER="NUmber"
        var VERSION=1
    }
    override fun onCreate(p0: SQLiteDatabase?) {

        var query = " create table " + TABLE_NAME + " ( " + ID + " integer primary key, " + NAME + " text, " + NUMBER + " text " + " ) "
        p0!!.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun insertdata(m:Model):Long
    {
        var db=writableDatabase
        var values=ContentValues()
        values.put(NAME,m.name)
        values.put(NUMBER,m.number)
        var id=db.insert(TABLE_NAME, ID,values)
        return id
    }
}


