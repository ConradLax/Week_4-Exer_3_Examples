package com.example.myapp

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var nicknameEditText: EditText
    private lateinit var nicknameTextView: TextView
    private lateinit var nicknameButon: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nicknameEditText = findViewById<EditText>(R.id.nickname_edit)
        nicknameTextView = findViewById(R.id.nickname_text)
        nicknameButon = findViewById(R.id.accept_nickname)

        findViewById<Button>(R.id.accept_nickname).setOnClickListener {
            saveNewNickname(it)
        }

        //for the updateNickname fxn
        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(it)
        }
    }

    @SuppressLint("ServiceCast")
    private fun saveNewNickname(view: View){
        nicknameTextView.text = nicknameEditText.text

        nicknameEditText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.accept_nickname)

        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        // Set the focus to the edit text.
        editText.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
}
