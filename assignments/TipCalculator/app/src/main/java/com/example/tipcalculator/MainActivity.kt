package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.editTextNumber)
        val button = findViewById<Button>(R.id.button)
        val newline = "\n"


        editText.setOnClickListener{
            editText.text.clear()
        }

        button.setOnClickListener{

            val inputString = editText.text.toString()


            if (inputString == ""){
                textView.text = getString(R.string.fail)
            }else{
                val input = Integer.parseInt(inputString)
                textView.text = getString(R.string.the_tips_are_as_follows)+
                        newline+"10% = "+(input +(input*0.1))+
                        newline+"15% = "+(input +(input*0.15))+
                        newline+"20% = "+(input +(input*0.2))
            }

            }

        }

}
