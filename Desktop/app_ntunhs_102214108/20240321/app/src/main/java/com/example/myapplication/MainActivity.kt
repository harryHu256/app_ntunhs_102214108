package com.example.myapplication

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import java.time.Year


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtID = findViewById<EditText>(R.id.edtID)
        val edtPwd = findViewById<EditText>(R.id.edtPWD)
        val edtName = findViewById<EditText>(R.id.edtName)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPhone_num = findViewById<EditText>(R.id.edtPhone)
        val edtBdate = findViewById<EditText>(R.id.edtBdate)
        val radBtnGrp_Gender = findViewById<RadioGroup>(R.id.radBtn_group_gender)
        val chkCar = findViewById<CheckBox>(R.id.chkCar)
        val chkBike = findViewById<CheckBox>(R.id.chkBike)
        val chkMoto = findViewById<CheckBox>(R.id.chkMoto)
        val chkMRT = findViewById<CheckBox>(R.id.chkMRT)
        val btnSend = findViewById<Button>(R.id.btnSend)


        var gender = ""

        radBtnGrp_Gender.setOnCheckedChangeListener { _, checkedId ->
            gender = radBtnGrp_Gender.findViewById<RadioButton>(checkedId).text.toString()
        }

        edtBdate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this, { _, year, month, day ->
                run {
                    var format = "${setDateFormat(year, month, day)}"
                    edtBdate.setText(format)
                }
            }, year, month, day).show()
        }

        btnSend.setOnClickListener {
            var vehicle = ""
            if (chkCar.isChecked()) {
                vehicle += chkCar.getText().toString() + ","
            }
            if (chkMoto.isChecked()) {
                vehicle += chkMoto.getText().toString() + ","
            }
            if (chkBike.isChecked()) {
                vehicle += chkBike.getText().toString() + ","
            }
            if (chkMRT.isChecked()) {
                vehicle += chkMRT.getText().toString()
            }
            val user_Message = "ID: " + edtID.text.toString() + "\n" +
                    "PWD: " + edtPwd.text.toString() + "\n" +
                    "Name: " + edtID.text.toString() + "\n" +
                    "Email: " + edtPwd.text.toString() + "\n" +
                    "Phone number: " + edtPwd.text.toString() + "\n" +
                    "Bdate: " + edtID.text.toString() + "\n" +
                    "gender: " + edtPwd.text.toString() + "\n" +
                    "Vehicle: " + vehicle
            AlertDialog.Builder(this).setTitle("userProfile")
                .setMessage(user_Message).create().show()
        }

    }
    private fun setDateFormat(year: Int, month: Int, day: Int): String {
        return "$year-$month-$day"
    }
}