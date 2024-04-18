package com.example.guess_number
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.guess_number.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val guessNumberGame = Guess_Number_Game()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.guessbutton.setOnClickListener {
            val guess = binding.editText.text.toString().toIntOrNull()
            if (guess != null) {
                val result = guessNumberGame.guess(guess)
                binding.resulttextView.text = result
            } else {
                binding.resulttextView.text = "請輸入一個數字"
            }
        }
        binding.resetbutton.setOnClickListener {
            guessNumberGame.reset()
            binding.editText.text.clear()
            binding.resulttextView.text = "讓我們再猜一次"
        }
    }
}