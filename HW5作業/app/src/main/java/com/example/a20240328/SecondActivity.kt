package com.example.a20240328

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val txttest = findViewById<TextView>(R.id.txttest)
        val btnBacktoFirst = findViewById<Button>(R.id.btnBacktoFirst)
        val text = intent.getBundleExtra("key")?.getString("name").toString()

        txttest.setText(text)

        btnBacktoFirst.setOnClickListener {
            finish()
        }
    }
    var lastTime: Long = 0
    override fun finish() {
        val currentTime = System.currentTimeMillis()
        if(currentTime - lastTime > 3*1000) {
            lastTime = currentTime
            Toast.makeText(this,"再按一下離開",Toast.LENGTH_SHORT).show()
        }else{
            super.finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}