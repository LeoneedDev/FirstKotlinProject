package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.rollButton)

        rollButton.setOnClickListener {
            rollDice()
        }

    }

    private fun rollDice() {
        val diceRoll = Dice(6).roll()
        val resultTextView: TextView = findViewById(R.id.result)
        resultTextView.text = diceRoll.toString()
        when (resultTextView.text) {
            "5" -> Toast.makeText(this, "Рил пидор", Toast.LENGTH_SHORT).show()
            "3" -> Toast.makeText(this, "Мама тебя любит", Toast.LENGTH_SHORT).show()
            else -> Toast.makeText(this, "Не сегодня чувак", Toast.LENGTH_SHORT).show()
        }
    }
}

private class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}