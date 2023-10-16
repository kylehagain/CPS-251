package com.example.addnamesavedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.displayNames)
        val editText = findViewById<EditText>(R.id.editTextName)
        val button = findViewById<Button>(R.id.button)

        val newLine = "\n"

        editText.setOnClickListener{
            editText.text.clear()
        }

        button.setOnClickListener{

            val inputString = editText.text.toString()


            if (inputString == ""){
                button.text = getString(R.string.fail)
                button.textSize = 22F
            }else{
                if (textView.text == getString(R.string.please_enter)){
                    textView.text = ""
                }
                if (button.text == getString(R.string.fail)){
                        button.text = getString(R.string.enter_name)
                    }
                textView.text = textView.text.toString() +newLine+inputString
            }

        }

    }
}
