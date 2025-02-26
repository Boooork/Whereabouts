package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.fragments.SettingsFragment


class HomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the listeners for button clicks
        findViewById<Button>(R.id.devicesButton).setOnClickListener {
           // startActivity(Intent(this, ForumActivity::class.java))
        }

        findViewById<Button>(R.id.discussionsButton).setOnClickListener {
            startActivity(Intent(this, ForumBoard::class.java))

        }


        findViewById<Button>(R.id.mapsButton).setOnClickListener {
            // Log out and go to the Login screen
            //startActivity(Intent(this, LoginActivity::class.java))
            //finish()  // Close com.example.myapplication.HomeActivity so the user can't go back to it
        }
        findViewById<Button>(R.id.settingsButton).setOnClickListener {
            startActivity(Intent(this, SettingsFragment::class.java))

        }

    }
}
