package com.example.learning

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.internal.illegalDecoyCallException


class MainActivity : ComponentActivity() {

    var firstNumber:String = ""
    var secondNumber:String = ""
    var operator: String = ""
    var theOutcome:Double=0.0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main)


        val btn_cancel = findViewById<Button>(R.id.btn_cancel)
        val btn_mutiply = findViewById<Button>(R.id.btn_multiply)
        val btn_clear = findViewById<Button>(R.id.btn_clear)
        val btn_7 = findViewById<Button>(R.id.btn_7)
        val btn_1 = findViewById<Button>(R.id.btn_1)
        val btn_2 = findViewById<Button>(R.id.btn_2)
        val btn_3 = findViewById<Button>(R.id.btn_3)
        val btn_4 = findViewById<Button>(R.id.btn_4)
        val btn_5 = findViewById<Button>(R.id.btn_5)
        val btn_6 = findViewById<Button>(R.id.btn_6)
        val btn_8 = findViewById<Button>(R.id.btn_8)
        val btn_9 = findViewById<Button>(R.id.btn_9)
        val btn_0 = findViewById<Button>(R.id.btn_0)
        val btn_dot = findViewById<Button>(R.id.btn_dot)
        val btn_equal = findViewById<Button>(R.id.btn_equal)
        val btn_add = findViewById<Button>(R.id.btn_add)
        val btn_decline = findViewById<Button>(R.id.btn_decline)
        val btn_divide = findViewById<Button>(R.id.btn_divide)
        val btn_reciprocal = findViewById<Button>(R.id.btn_reciprocal)
        //开平方
        val btn_sqrt = findViewById<Button>(R.id.btn_sqrt)
        val screen = findViewById<TextView>(R.id.screen)


        //add the click listener on the button
        btn_sqrt.setOnClickListener {

                theOutcome = Math.sqrt(firstNumber.toDouble())
                screen.text=theOutcome.toString()


        }
        btn_reciprocal.setOnClickListener {

               theOutcome=1/firstNumber.toDouble()
               screen.text=theOutcome.toString()

        }
        btn_dot.setOnClickListener {
            refreshScreenText(screen,btn_dot)
        }
        btn_clear.setOnClickListener {
             firstNumber = ""
             secondNumber = ""
             operator = ""

            screen.text=""
        }
        btn_divide.setOnClickListener {
            operatorFinal(btn_divide, screen)
        }
        btn_cancel.setOnClickListener {
            val mother=screen.text.toString()
            val sun=mother.substring(0,mother.length-1)
            screen.setText(sun)
        }
        btn_add.setOnClickListener {
            operatorFinal(btn_add, screen)

        }
        btn_decline.setOnClickListener {
            operatorFinal(btn_decline, screen)


        }
        btn_mutiply.setOnClickListener {
            operatorFinal(btn_mutiply, screen)


        }
        btn_equal.setOnClickListener {
             when(operator){
                "+" ->{

                    theOutcome=firstNumber.toDouble()+secondNumber.toDouble()
                }
                 "-" ->{

                     theOutcome=firstNumber.toDouble()-secondNumber.toDouble()
                 }
                 "X" ->{
                 theOutcome=firstNumber.toDouble()*secondNumber.toDouble() }
                 "/" ->{

                 theOutcome=firstNumber.toDouble()/secondNumber.toDouble()
             }


                else -> throw
                        illegalDecoyCallException("the illegal operation")
            }
            screen.text = theOutcome.toString()

        }
        btn_0.setOnClickListener {
            refreshScreenText(screen, btn_0)

        }
        btn_1.setOnClickListener {
            refreshScreenText(screen, btn_1)

        }
        btn_2.setOnClickListener {
            refreshScreenText(screen, btn_2)

        }
        btn_3.setOnClickListener {
            refreshScreenText(screen, btn_3)

        }
        btn_4.setOnClickListener {
            refreshScreenText(screen, btn_4)

        }
        btn_5.setOnClickListener {
            refreshScreenText(screen, btn_5)

        }
        btn_6.setOnClickListener {
            refreshScreenText(screen, btn_6)

        }
        btn_7.setOnClickListener{
            refreshScreenText(screen, btn_7)
    }
        btn_8.setOnClickListener {
            refreshScreenText(screen, btn_8)

        }
        btn_9.setOnClickListener {
            refreshScreenText(screen, btn_9)

        }



    }




    //judge whether the string contains a operator
    private fun operatorJudge():Boolean{

        if(operator!=""){
            return false
        }else{
            return true
        }

    }

// the combined fun used on operator
    private fun operatorFinal(button: Button, screen: TextView) {
        if (operatorJudgeAndAdd(button)) {

            refreshScreenText(screen, button)
        }
    }


    
    
//the consist fun of the operatorFinal
    private fun operatorJudgeAndAdd(button:Button): Boolean {
        if (operator == "") {
            operator = button.text.toString()
            return true
        } else {
            button.isEnabled = false
            return false
        }
    }
//add text into the screen
    private fun refreshScreenText(screen: TextView, button: Button) {

    if (operatorJudge()) {
        secondNumber += button.text.toString()
    } else {
        firstNumber += button.text.toString()
    }
        
        val originalText = screen.text.toString()
        val text = button.text.toString()
        val finalText = originalText + text

        screen.setText(finalText)
    }



}






