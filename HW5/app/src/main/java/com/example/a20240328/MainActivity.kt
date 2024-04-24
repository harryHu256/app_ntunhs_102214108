package com.example.a20240328

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnguessnumber = findViewById<Button>(R.id.btnguessnumber)
        val btnrockpaperscissors = findViewById<Button>(R.id.btnrockpaperscissors)

        btnguessnumber.setOnClickListener{
            val guessNumberintent = Intent(this, guess_number::class.java)
            startActivity(guessNumberintent)

        }

        btnrockpaperscissors.setOnClickListener{
            val rockpaperscissorsintent = Intent(this, Rockpaperscissors::class.java)
            startActivity(rockpaperscissorsintent)

        }
    }
}