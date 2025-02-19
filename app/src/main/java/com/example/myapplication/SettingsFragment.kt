package com.example.myapplication.fragments

import com.example.myapplication.R
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var locationToggle: Switch
    private lateinit var enable2FA: Switch
    private lateinit var pushNotifications: Switch
    private lateinit var soundNotifications: Switch
    private lateinit var themeSelection: TextView
    private lateinit var languageSelection: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get shared preferences to store settings
        sharedPreferences = requireActivity().getSharedPreferences("SettingsPrefs", Context.MODE_PRIVATE)

        // Find the UI elements
        locationToggle = view.findViewById(R.id.location_toggle)
        enable2FA = view.findViewById(R.id.enable_2fa)
        pushNotifications = view.findViewById(R.id.push_notifications)
        soundNotifications = view.findViewById(R.id.sound_notifications)
        themeSelection = view.findViewById(R.id.theme_selection)
        languageSelection = view.findViewById(R.id.language_selection)

        // Load saved settings when the page is loaded
        loadSettings()

        // Set up listeners to handle user input
        setupListeners()
    }

    // Load the saved settings from shared preferences
    private fun loadSettings() {
        locationToggle.isChecked = sharedPreferences.getBoolean("share_location", true)
        enable2FA.isChecked = sharedPreferences.getBoolean("enable_2fa", false)
        pushNotifications.isChecked = sharedPreferences.getBoolean("push_notifications", true)
        soundNotifications.isChecked = sharedPreferences.getBoolean("sound_notifications", true)

        themeSelection.text = sharedPreferences.getString("theme", "Theme: Light Mode")
        languageSelection.text = sharedPreferences.getString("language", "Language: English")
    }

    // Set up listeners for each setting change
    private fun setupListeners() {
        locationToggle.setOnCheckedChangeListener { _, isChecked ->
            saveSetting("share_location", isChecked)
        }

        enable2FA.setOnCheckedChangeListener { _, isChecked ->
            saveSetting("enable_2fa", isChecked)
        }

        pushNotifications.setOnCheckedChangeListener { _, isChecked ->
            saveSetting("push_notifications", isChecked)
        }

        soundNotifications.setOnCheckedChangeListener { _, isChecked ->
            saveSetting("sound_notifications", isChecked)
        }

        // When the theme option is clicked, change the theme
        themeSelection.setOnClickListener {
            changeTheme()
        }

        // When the language option is clicked, change the language
        languageSelection.setOnClickListener {
            changeLanguage()
        }
    }

    // Save the setting to shared preferences
    private fun saveSetting(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
        Toast.makeText(requireContext(), "Setting updated", Toast.LENGTH_SHORT).show()
    }

    // Change the theme between light and dark mode
    private fun changeTheme() {
        val newTheme = if (themeSelection.text.toString().contains("Light")) {
            "Theme: Dark Mode"
        } else {
            "Theme: Light Mode"
        }
        themeSelection.text = newTheme
        sharedPreferences.edit().putString("theme", newTheme).apply()
        Toast.makeText(requireContext(), "Theme changed", Toast.LENGTH_SHORT).show()
    }

    // Change the language between English and Spanish
    private fun changeLanguage() {
        val newLanguage = if (languageSelection.text.toString().contains("English")) {
            "Language: Spanish"
        } else {
            "Language: English"
        }
        languageSelection.text = newLanguage
        sharedPreferences.edit().putString("language", newLanguage).apply()
        Toast.makeText(requireContext(), "Language changed", Toast.LENGTH_SHORT).show()
    }
}
