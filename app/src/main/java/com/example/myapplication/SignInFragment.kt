package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SignInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_signin, container, false)

        // Find the TextView and set an OnClickListener
        val signUpRedirect = view.findViewById<TextView>(R.id.signupRedirect)
        signUpRedirect.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_signin_to_fragment_signup)
        }

        return view
    }
}
