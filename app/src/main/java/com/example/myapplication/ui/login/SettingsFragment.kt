package com.yourapp.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.yourapp.R
import com.yourapp.auth.LoginActivity

class SettingsFragment : Fragment() {

    private lateinit var locationToggle: Switch
    private lateinit var enable2FA: Switch
    private lateinit var pushNotifications: Switch
    private lateinit var soundNotifications: Switch
    private lateinit var themeSelection: TextView
    private lateinit var languageSelection: TextView
    private lateinit var logoutButton: Button
    private lateinit var deleteAccount: TextView

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize UI Components
        locationToggle = view.findViewById(R.id.location_toggle)
        enable2FA = view.findViewById(R.id.enable_2fa)
        pushNotifications = view.findViewById(R.id.push_notifications)
        soundNotifications = view.findViewById(R.id.sound_notifications)
        themeSelection = view.findViewById(R.id.theme_selection)
        languageSelection = view.findViewById(R.id.language_selection)
        logoutButton = view.findViewById(R.id.logout_button)
        deleteAccount = view.findViewById(R.id.delete_account)

        sharedPreferences = requireActivity().getSharedPreferences("SettingsPrefs", Context.MODE_PRIVATE)

        // Load saved settings
        loadSettings()

        // Set up listeners for toggles and buttons
        setupListeners()
    }

    private fun setupListeners() {
        val editor = sharedPreferences.edit()

        locationToggle.setOnCheckedChangeListener { _, isChecked ->
            editor.putBoolean("location_sharing", isChecked).apply()
        }

        enable2FA.setOnCheckedChangeListener { _, isChecked ->
            editor.putBoolean("two_factor_auth", isChecked).apply()
        }

        pushNotifications.setOnCheckedChangeListener { _, isChecked ->
            editor.putBoolean("push_notifications", isChecked).apply()
        }

        soundNotifications.setOnCheckedChangeListener { _, isChecked ->
            editor.putBoolean("sound_notifications", isChecked).apply()
        }

        themeSelection.setOnClickListener {
            showThemeSelectionDialog()
        }

        languageSelection.setOnClickListener {
            showLanguageSelectionDialog()
        }

        logoutButton.setOnClickListener {
            logoutUser()
        }

        deleteAccount.setOnClickListener {
            confirmAccountDeletion()
        }
    }

    private fun loadSettings() {
        locationToggle.isChecked = sharedPreferences.getBoolean("location_sharing", true)
        enable2FA.isChecked = sharedPreferences.getBoolean("two_factor_auth", false)
        pushNotifications.isChecked = sharedPreferences.getBoolean("push_notifications", true)
        soundNotifications.isChecked = sharedPreferences.getBoolean("sound_notifications", true)
        themeSelection.text = "Theme: ${sharedPreferences.getString("theme", "Light Mode")}"
        languageSelection.text = "Language: ${sharedPreferences.getString("language", "English")}"
    }

    private fun showThemeSelectionDialog() {
        val themes = arrayOf("Light Mode", "Dark Mode", "System Default")
        AlertDialog.Builder(requireContext())
            .setTitle("Select Theme")
            .setItems(themes) { _, which ->
                val selectedTheme = themes[which]
                sharedPreferences.edit().putString("theme", selectedTheme).apply()
                themeSelection.text = "Theme: $selectedTheme"
            }
            .show()
    }

    private fun showLanguageSelectionDialog() {
        val languages = arrayOf("English", "Spanish", "French", "German")
        AlertDialog.Builder(requireContext())
            .setTitle("Select Language")
            .setItems(languages) { _, which ->
                val selectedLanguage = languages[which]
                sharedPreferences.edit().putString("language", selectedLanguage).apply()
                languageSelection.text = "Language: $selectedLanguage"
            }
            .show()
    }

    private fun logoutUser() {
        val intent = Intent(requireActivity(), LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun confirmAccountDeletion() {
        AlertDialog.Builder(requireContext())
            .setTitle("Delete Account")
            .setMessage("Are you sure you want to delete your account? This action cannot be undone.")
            .setPositiveButton("Delete") { _, _ ->
                // API call to delete account or clear local user data
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
