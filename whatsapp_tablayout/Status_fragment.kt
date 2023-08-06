package com.example.whatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whatsapp.databinding.FragmentChatFragmentBinding
import com.example.whatsapp.databinding.FragmentStatusFragmentBinding


class Status_fragment : Fragment() {

    private var _binding: FragmentStatusFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_status_fragment, container, false)

        _binding = FragmentStatusFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

}