package com.example.prefrencescreen

import android.os.Bundle
import android.preference.PreferenceActivity

class MainActivity2 : PreferenceActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.pref)

    }
}