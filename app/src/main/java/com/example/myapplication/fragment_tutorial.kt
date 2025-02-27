package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class fragment_tutorial : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout
        val view = inflater.inflate(R.layout.fragment_tutorial, container, false)

        // Find the Next button and set up navigation
        val nextButton: Button = view.findViewById(R.id.btnNext)
        nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_tutorial_to_fragment_signup)
        }

        return view
    }
}
