package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class FragmentSignup : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_signup, container, false)

        // Find the TextView and set an OnClickListener
        val tvSignIn: TextView = view.findViewById(R.id.tvSignIn)
        tvSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_signup_to_fragment_signin)
        }

        return view
    }
}
