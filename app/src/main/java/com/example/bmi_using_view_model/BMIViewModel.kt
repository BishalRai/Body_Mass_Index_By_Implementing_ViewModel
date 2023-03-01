package com.example.bmi_using_view_model

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class BMIViewModel:ViewModel() {
    var heightInput: String by mutableStateOf("")
    var weightInput: String by mutableStateOf("")
/*
    val height = heightInput.toFloatOrNull() ?: 0.0f
    val weight = weightInput.toIntOrNull() ?: 0
*/
    private var height: Float = 0.0f
        get() {
            return heightInput.toFloatOrNull()?: 0.0f
        }
    private var weight: Float = 0.0f
        get() {
            return weightInput.toFloatOrNull()?: 0.0f
        }
    fun changeHeightInput(value:String){
        heightInput = value
    }
    fun changeWeightInput(value:String){
        weightInput = value
    }


    var finalResult: Float = 0.0f
        get(){
            val result = CalculatedBMI()
            //Log.d("VIEWMODEL",result.toString())
            return result
        }

    fun CalculatedBMI(): Float{
        //Log.d("VIEWMODEL","Calculating")
        /*Log.d("VIEWMODEL",heightInput)
        Log.d("VIEWMODEL",weightInput)

        Log.d("VIEWMODEL",height.toString())
        Log.d("VIEWMODEL",weight.toString())
        */
        val bmi = if(weight > 0 && height > 0) weight / (height * height) else 0.0f
        //Log.d("VIEWMODEL calculation",bmi.toString())
        return  bmi
    }
}