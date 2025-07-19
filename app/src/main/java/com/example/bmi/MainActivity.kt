package com.example.bmi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val bmiBtn = findViewById<Button>(R.id.calculate)

        bmiBtn.setOnClickListener{
            calculateBmi()
        }

    }

    private fun calculateBmi() {
        val weight = findViewById<EditText>(R.id.weight).text.toString().toFloatOrNull()
        val height = findViewById<EditText>(R.id.hieght).text.toString().toFloatOrNull()
        val bmiScore = findViewById<TextView>(R.id.bmi)
        val health = findViewById<TextView>(R.id.health)

        if (weight != null && height != null){
            val heightM = height/100
            val bmi = weight/(heightM*heightM)
//            bmiScore.text = String.format("%.2f",bmi)
            bmiScore.text = "$bmi"

            val condition = when{
                bmi < 18.5 -> "Under Weight"
                bmi < 25 -> "Normal Weight"
                bmi < 30 -> "Over Weight"
                else-> "Obese"
            }
            health.text = "$condition"
        }else {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show()

        }

    }
}