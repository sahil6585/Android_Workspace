package com.example.bottom_nev

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bottom_nev.databinding.FragmentAnimalBinding


class AnimalFragment : Fragment() {

    private var _binding: FragmentAnimalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?
    {
        _binding = FragmentAnimalBinding.inflate(inflater, container, false)
        val view = binding.root

        inflater.inflate(R.layout.fragment_animal, container, false)



        return view
    }

}