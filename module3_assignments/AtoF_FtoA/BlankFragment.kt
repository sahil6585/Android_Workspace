package com.example.atof_ftoa

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.atof_ftoa.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

    private var _binding: FragmentBlankBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
         inflater.inflate(R.layout.fragment_blank, container, false)
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.fragment.setOnClickListener {
            var i = Intent(requireActivity(), MainActivity2::class.java)
            startActivity(i)
        }

        return view
    }

}