package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class FragmentSignup : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_signup, container, false)

        // Navigate to Sign In screen
        val tvSignIn: TextView = view.findViewById(R.id.tvSignIn)
        tvSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_signup_to_fragment_signin)
        }

        // Navigate to HomeActivity when Sign Up button is clicked
        val signUpButton: Button = view.findViewById(R.id.signUpButton)
        signUpButton.setOnClickListener {
            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)
            requireActivity().finish()  // Closes the sign-up screen to prevent going back
        }

        return view
    }
}
