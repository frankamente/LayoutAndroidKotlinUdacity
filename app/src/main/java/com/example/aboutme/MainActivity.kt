package com.example.aboutme

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val doneButton: Button = findViewById(R.id.done_button)
        doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        val editText: EditText = findViewById(R.id.nickname_edit)
        val nicknameText: TextView = findViewById(R.id.nickname_text)
        if (!editText.text.isNullOrEmpty()) {
            nicknameText.text = editText.text
            nicknameText.setTextColor(Color.BLACK)
            nicknameText.visibility = View.VISIBLE
            view.visibility = View.GONE
            editText.visibility = View.GONE
        } else{
            nicknameText.text = resources.getText(R.string.enter_name)
            nicknameText.visibility = View.VISIBLE
            nicknameText.setTextColor(Color.RED)
        }
    }

}
