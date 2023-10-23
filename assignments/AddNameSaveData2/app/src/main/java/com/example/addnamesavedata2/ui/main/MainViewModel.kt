package com.example.addnamesavedata2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var inputText: MutableLiveData<String> = MutableLiveData()
    var outputText: MutableLiveData<String> = MutableLiveData()

    private val names: MutableList<String> = mutableListOf()

    fun changeText(){

        val inputValue = inputText.value

        var checker = false //Variable to check
        var saveData = ""   // Variable to save in

        if (!inputValue.isNullOrBlank()) {                     //If input not blank....

            if (checker == true){                                 //If last input errored...
                outputText.value = saveData                       //bring back original list.
            }
            names.add(inputText.value!!)                          //Add name to list
            outputText.value = names.joinToString("\n")  //Output = List joinToString'd

        }else{                                                 //Otherwise...
            checker = true                                        //Activates checker
            saveData = outputText.value.toString()                //Saves list into saveData
            outputText.value = "REAL CHARACTERS ONLY" + "\n" + "PLEASE TRY AGAIN" //Error message
        }
    }


}