package com.yigithansonmez.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.yigithansonmez.kotlincalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tasarim:ActivityMainBinding

    private var num1:Int = 0
    private var num2:Int = 0
    private var totalSum:Int = 0
    private var isNum1orNum2:Boolean = true // true num1, false,num2
    private var plusPressCount:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        tasarim.button0.setOnClickListener(this)
        tasarim.button1.setOnClickListener(this)
        tasarim.button2.setOnClickListener(this)
        tasarim.button3.setOnClickListener(this)
        tasarim.button4.setOnClickListener(this)
        tasarim.button5.setOnClickListener(this)
        tasarim.button6.setOnClickListener(this)
        tasarim.button7.setOnClickListener(this)
        tasarim.button8.setOnClickListener(this)
        tasarim.button9.setOnClickListener(this)
        tasarim.buttonAC.setOnClickListener(this)
        tasarim.buttonComma.setOnClickListener(this)
        tasarim.buttonPlus.setOnClickListener(this)
        tasarim.buttonEqual.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        var button = v as Button;
        var buttonText = button.text
        Log.e("ButtonText","$buttonText")

        if(buttonText == "+"){
            totalSum += num1
            UpdateDisplayTextView(totalSum.toString())
            num1 = 0
            /*
            if(plusPressCount > 1){
                FinishCalculation()
                return
            }
            if(plusPressCount % 2 == 0){
                isNum1orNum2 = true
            }
            else if(plusPressCount % 2 == 1){
                isNum1orNum2 = false
            }*/
        }
        else if(buttonText == "="){
            FinishCalculation()
        }
        else if(buttonText == "AC"){
            ClearCalculation()
            totalSum = 0
            UpdateDisplayTextView("0")
        }
        else if(buttonText == ","){
            Toast.makeText(this, "not implemented yet :(", Toast.LENGTH_SHORT).show()
        }
        else{
            HandleNumberTyping(buttonText.toString())
        }
    }

    fun UpdateDisplayTextView(text:String){
        tasarim.displayTextView.text = text.toString()
    }

    fun HandleNumberTyping(buttonText:String){
        if(isNum1orNum2){
            var tempString:String
            if(num1.toString() == "0") {
                tempString = buttonText
            }
            else{
                tempString = num1.toString() + buttonText
            }
            num1 = tempString.toInt()
            UpdateDisplayTextView(num1.toString())
        }
    }

    fun ClearCalculation(){
        num1 = 0
        num2 = 0
        isNum1orNum2 = true
        plusPressCount = 0
    }

    fun FinishCalculation(){
        totalSum += num1
        UpdateDisplayTextView(totalSum.toString())
        num1 = 0
    }
}