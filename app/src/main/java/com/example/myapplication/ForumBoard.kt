package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityForumBoardBinding


class ForumBoard : AppCompatActivity() {

private lateinit var binding: ActivityForumBoardBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityForumBoardBinding.inflate(layoutInflater)
     setContentView(binding.root)
//      val addButton = findViewById<Button>(R.id.addPostButton)
//      val backButton = findViewById<Button>(R.id.backButton)
//      val trashButton = findViewById<Button>(R.id.deletePostButton)

        val postButton = findViewById<Button>(R.id.post_button)

        postButton.setOnClickListener {
            val postIntent = Intent(this, ForumDoc::class.java)
            startActivity(postIntent)
        }
//     addButton.setOnClickListener {
//
//        val addIntent = Intent(this, ForumDoc::class.java)
//         startActivity(addIntent)
//      }
//
//     backButton.setOnClickListener {
//         val intent = Intent(this, SignInActivity::class.java)
//         startActivity(intent)
//      }
//
//     trashButton.setOnClickListener{
//
//      }



    }



}