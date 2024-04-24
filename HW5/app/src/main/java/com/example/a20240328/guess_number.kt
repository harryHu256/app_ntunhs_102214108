package com.example.a20240328

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import java.util.*


class guess_number : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.guess_number)
        val result_textview = findViewById<TextView>(R.id.result_textView)
        val guess_button = findViewById<Button>(R.id.guess_button)
        val reset_button = findViewById<Button>(R.id.reset_button)
        val editText = findViewById<EditText>(R.id.editText)
        val valdate_num:Int
        var secret :Int = Random().nextInt(100)+1
        var minNum = 1
        var maxNum = 100
        guess_button.setOnClickListener {
            val guess = editText.text.toString().toIntOrNull()
            if (guess != null) {
                if (guess == secret) {
                    result_textview.text = "猜對了！"
                } else if(guess > secret){
                    maxNum = guess - 1
                    result_textview.text = "太大了 !區間：$minNum ~ $maxNum"

                }else if(guess < secret){
                    minNum = guess + 1
                    result_textview.text = "太小了 !區間：$minNum ~ $maxNum"
                }
            } else {
                result_textview.text = "請輸入一個數字"
            }
        }

        reset_button.setOnClickListener {
            secret = Random().nextInt(100) + 1
            minNum = 1
            maxNum = 100
            editText.text.clear()
            result_textview.text = "讓我們再猜一次"

        }
    }
}