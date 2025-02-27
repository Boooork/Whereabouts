package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AlertDialog

class ForumFragment : Fragment(R.layout.fragment_forum) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the Add Forum Post button
        val addPostButton = view.findViewById<Button>(R.id.add_post_button)

        // Set click listener to show dialog
        addPostButton.setOnClickListener {
            // Inflate the dialog layout
            val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_post, null)

            // Set up the AlertDialog
            val dialogBuilder = AlertDialog.Builder(requireContext())
                .setView(dialogView)
                .setCancelable(true)

            // Create the dialog
            val dialog = dialogBuilder.create()

            // Find EditText fields in the dialog layout
            val nameEditText = dialogView.findViewById<EditText>(R.id.dialog_name)
            val subjectEditText = dialogView.findViewById<EditText>(R.id.dialog_subject)
            val contentEditText = dialogView.findViewById<EditText>(R.id.dialog_post_content)
            val postButton = dialogView.findViewById<Button>(R.id.dialog_post_button)

            // Set click listener for the Post button in the dialog
            postButton.setOnClickListener {
                val name = nameEditText.text.toString()
                val subject = subjectEditText.text.toString()
                val content = contentEditText.text.toString()

                // Check if all fields are filled
                if (name.isEmpty() || subject.isEmpty() || content.isEmpty()) {
                    Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
                } else {
                    // For now, show a Toast when the post is added
                    Toast.makeText(requireContext(), "Post Added", Toast.LENGTH_SHORT).show()
                    // Dismiss the dialog
                    dialog.dismiss()
                }
            }

            // Show the dialog
            dialog.show()
        }
    }
}
