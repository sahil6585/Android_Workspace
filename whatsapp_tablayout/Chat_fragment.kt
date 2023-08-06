package com.example.whatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whatsapp.databinding.FragmentChatFragmentBinding
import com.example.whatsapp.databinding.FragmentStatusFragmentBinding


class Chat_fragment : Fragment() {

    private var _binding: FragmentChatFragmentBinding? = null
    private val binding get() = _binding!!

    lateinit var list:MutableList<Model>

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?

    {
        // Inflate the layout for this fragment
        _binding = FragmentChatFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

       inflater.inflate(R.layout.fragment_chat_fragment, container, false)




        list=ArrayList()


        list.add(Model(R.drawable.a,"Sahil Jagani","Han","Yesterday"))
        list.add(Model(R.drawable.b,"Sahil Jagani","Han","Yesterday"))
        list.add(Model(R.drawable.c,"Sahil Jagani","Han","Yesterday"))
        list.add(Model(R.drawable.d,"Sahil Jagani","Han","Yesterday"))
        list.add(Model(R.drawable.e,"Sahil Jagani","Han","Yesterday"))
        list.add(Model(R.drawable.f,"Sahil Jagani","Han","Yesterday"))
        list.add(Model(R.drawable.a,"Sahil Jagani","Han","Yesterday"))
        list.add(Model(R.drawable.a,"Sahil Jagani","Han","Yesterday"))
        list.add(Model(R.drawable.a,"Sahil Jagani","Han","Yesterday"))
        list.add(Model(R.drawable.a,"Sahil Jagani","Han","Yesterday"))


        var adapter=MyAdapter2(requireActivity(),list)
        binding.listview.adapter=adapter

        return view
    }

}