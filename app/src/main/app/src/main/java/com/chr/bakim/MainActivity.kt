package com.yourapp.toyotachr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kmInput = findViewById<EditText>(R.id.kmInput)
        val lastOilChange = findViewById<EditText>(R.id.lastOilChange)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val resultText = findViewById<TextView>(R.id.resultText)

        btnCalculate.setOnClickListener {
            val currentKm = kmInput.text.toString().toIntOrNull()
            val lastOilKm = lastOilChange.text.toString().toIntOrNull()

            if (currentKm == null || lastOilKm == null) {
                resultText.text = "Lütfen tüm alanları doldurun."
                return@setOnClickListener
            }

            val remainingOilKm = 10000 - (currentKm - lastOilKm)

            val oilMessage = if (remainingOilKm <= 0) {
                "Yağ değişimi GECİKMİŞ! Acil yapılmalı."
            } else {
                "Yağ değişimine kalan km: $remainingOilKm"
            }

            resultText.text = oilMessage
        }
    }
}
