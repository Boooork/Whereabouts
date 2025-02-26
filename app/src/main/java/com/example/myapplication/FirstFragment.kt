package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentFirstBinding
import androidx.navigation.fragment.findNavController


class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Use a Handler to delay navigation for 2-3 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            // Navigate to the sign-up screen after the delay
            findNavController().navigate(R.id.action_firstFragment_to_fragment_tutorial)
        }, 9000) // 9000ms = 9secs
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
