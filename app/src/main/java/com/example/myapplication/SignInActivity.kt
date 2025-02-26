package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fragment_signin)

        val signIntoUp = findViewById<TextView>(R.id.signupRedirect)
        signIntoUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        val hittingSignIn = findViewById<Button>(R.id.signInButton)
        hittingSignIn.setOnClickListener {
            val intent = Intent(this, ForumBoard::class.java)
            startActivity(intent)
        }
    }
}
