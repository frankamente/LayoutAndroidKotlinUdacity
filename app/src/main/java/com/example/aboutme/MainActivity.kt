package com.example.aboutme

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName(name = "Fran Márquez")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        binding.apply {

            if (!nicknameEdit.text.isNullOrEmpty()) {
                myName?.nickname = nicknameEdit.text.toString()
                invalidateAll()
                nicknameText.setTextColor(Color.BLACK)
                nicknameText.visibility = View.VISIBLE
                view.visibility = View.GONE
                nicknameEdit.visibility = View.GONE
            } else {
                myName?.nickname = resources.getText(R.string.enter_name).toString()
                nicknameText.visibility = View.VISIBLE
                nicknameText.setTextColor(Color.RED)
            }
        }
    }

}
