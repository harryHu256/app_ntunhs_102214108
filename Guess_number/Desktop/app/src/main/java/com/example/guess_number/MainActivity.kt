package com.example.guess_number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val guess_button = findViewById<Button>(R.id.guess_button)
        val reset_button = findViewById<Button>(R.id.reset_button)
        val editText = findViewById<EditText>(R.id.editText)
        var validate_num: Int

        var minRange = 1
        var maxRange = 100

        var secret: Int = Random().nextInt(100) + 1

        guess_button.setOnClickListener {

            validate_num = editText.text.toString().toInt()

            var ans_str: String

            if (validate_num in minRange..maxRange) {

                if (validate_num == secret) {
                    ans_str = "恭喜你猜對了！"
                } else if (validate_num > secret) {

                    ans_str = "你猜得比較大喔"
                    maxRange = validate_num - 1
                } else {

                    ans_str = "你猜的比較小喔"
                    minRange = validate_num + 1
                }
            } else {

                ans_str = "請輸入$minRange 到 $maxRange 之間的數字"
            }

            val range_str = "範圍: $minRange 到 $maxRange"
            textView.text = "$ans_str\n$range_str"

            val toastText = "$ans_str\n$range_str"
            Toast.makeText(applicationContext, toastText, Toast.LENGTH_SHORT).show()
        }

        reset_button.setOnClickListener {
            secret = Random().nextInt(maxRange - minRange + 1) + minRange
            minRange = 1
            maxRange = 100
            textView.text = "我們再猜一次"
        }

    }
}
