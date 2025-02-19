package com.example.myapplication.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.ui.forum.ForumActivity
import com.example.myapplication.ui.login.LoginActivity
import com.example.myapplication.ui.settings.SettingsActivity

class HomeActivity : AppCompatActivity(R.layout.activity_home) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up the listeners for button clicks
        findViewById<View>(R.id.btnForum).setOnClickListener {
            // Navigate to the Forum activity
            startActivity(Intent(this, ForumActivity::class.java))
        }

        findViewById<View>(R.id.btnSettings).setOnClickListener {
            // Navigate to the Settings activity
            startActivity(Intent(this, SettingsActivity::class.java))
        }


        findViewById<View>(R.id.btnSignOut).setOnClickListener {
            // Log out and go to the Login screen
            startActivity(Intent(this, LoginActivity::class.java))
            finish() // Close HomeActivity so the user can't go back to it
        }
    }
}
