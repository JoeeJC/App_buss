package com.itu.test

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton




class homeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val button = view.findViewById<ImageButton>(R.id.imageButton3)
        val button2 = view.findViewById<ImageButton>(R.id.imageButton4)
        button.setOnClickListener{
            val intent = Intent(requireContext(), MenuActivity::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener{
            val intent = Intent(requireActivity(), MapActivity::class.java)
            startActivity(intent)
        }
        return view

    }
}


