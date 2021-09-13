package com.example.spacex

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.spacex.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        nextButton()
    }

    fun nextButton() {

        var nextButton = findViewById<Button>(R.id.nextButton)
        var inputText = findViewById<EditText>(R.id.inputText)

        nextButton.setOnClickListener {
            val sharedPreferences =
                getSharedPreferences(getString(R.string.pref_key), MODE_PRIVATE)

            val editor: SharedPreferences.Editor = sharedPreferences.edit()

            editor.putString(getString(R.string.pref_key), inputText.text.toString())
            editor.apply();

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }
}