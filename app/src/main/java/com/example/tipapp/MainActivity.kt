// You will write an App that accepts the cost of a meal as a number field, then has a spinner that
// shows 5%, 10%, 15%, 20%, and 25%. This will be a tip calculator. The user will be able to enter
// the meal cost and select a percentage, then the App will calculate the tip amount.

package com.example.tipapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    var mealTotal: Double = 0.0
    var totalCharge: Double = 0.0
    var tip = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // assign variable to interface views
        val userTotal: EditText = findViewById(R.id.idAmountInput)
        val group: Spinner = findViewById(R.id.idSpinner)
        val submit: Button = findViewById(R.id.idSubmitBtn)
        val result: TextView = findViewById(R.id.idResult)

        // calculate tip when button is clicked
        submit.setOnClickListener {

            mealTotal = userTotal.text.toString().toDouble()
            tip = group.selectedItem.toString()

            // convert string percent to decimal
            val tipPercent = when(tip){
                "5%" -> .05
                "10%" -> .1
                "15%" -> .15
                "20%" -> .2
                "25%" -> .25
                else -> 0.0
            }

            // determine total charge including tip
            totalCharge = mealTotal + (mealTotal * tipPercent)

            val outputFormat = DecimalFormat("$###,###.00")
            val resultText = "Your total including tip is ${outputFormat.format(totalCharge)}"

            // display to user
            result.text = resultText
        }
    }
}