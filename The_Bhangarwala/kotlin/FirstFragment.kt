package com.example.thebhangarwala

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thebhangarwala.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

}