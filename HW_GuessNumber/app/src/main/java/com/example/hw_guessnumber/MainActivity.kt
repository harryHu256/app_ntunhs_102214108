package com.example.hw_guessnumber


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    val TAG : String = MainActivity::class.java.simpleName
    private lateinit var handler: Handler

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handler = Handler(Looper.getMainLooper())

        val textView = findViewById<TextView>(R.id.result_textView)
        val result_button = findViewById<Button>(R.id.reset_button)
        val editTextText1 = findViewById<EditText>(R.id.editTextText1)
        val guess_button = findViewById<Button>(R.id.guess_button)
        var validate_num:Int
        var start:Int = 1
        var end:Int = 100

        var secret : Int = Random().nextInt(100)+1

        guess_button.setOnClickListener {
            Toast.makeText(this, editTextText1.text, Toast.LENGTH_LONG).show()
            textView.text=editTextText1.text
            validate_num=editTextText1.text.toString().toInt()-secret
            var ans_str:String="你猜對了喔"

            if(validate_num>0){
                end=editTextText1.text.toString().toInt()
                var strend=end.toInt().toString()
                var strstart=start.toInt().toString()
                ans_str = "你猜的比較大喔！" + "區間："+ strstart+" ~ "+strend

            }else if(validate_num<0){
                start=editTextText1.text.toString().toInt()
                var strend=end.toInt().toString()
                var strstart=start.toInt().toString()
                ans_str = "你猜的比較小喔！"+"區間："+ strstart+" ~ "+strend
            }
            textView.text=ans_str
            if(textView.text=="你猜對了喔"){
                handler.postDelayed(
                    {Toast.makeText(this, "6秒後重置結果!", Toast.LENGTH_SHORT).show()}, 6000
                )
                secret=Random().nextInt(10)+1
                start=1
                end=100
                textView.text="你猜對了喔"
                editTextText1.text.clear()

            }
        }

        result_button.setOnClickListener {
            secret=Random().nextInt(10)+1
            start=1
            end=100
            textView.text="我們再猜一次"
            editTextText1.text.clear()
        }
    }

    override fun onDestroy(){
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}