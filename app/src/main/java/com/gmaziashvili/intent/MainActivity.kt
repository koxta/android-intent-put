package com.gmaziashvili.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    enum class Operation {
        Sum, Subtract, Multiply, Divide
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val sumButton: Button = findViewById (R.id.sum)
        val subtractButton: Button = findViewById (R.id.subtract)
        val multiplyButton: Button = findViewById (R.id.multiply)
        val divideButton: Button = findViewById (R.id.divide)

        sumButton.setOnClickListener { runSecondActivity(Operation.Sum) }
        subtractButton.setOnClickListener { runSecondActivity(Operation.Subtract) }
        multiplyButton.setOnClickListener { runSecondActivity(Operation.Multiply) }
        divideButton.setOnClickListener { runSecondActivity(Operation.Divide) }

    }

    private fun calculate(operation: Operation):String{
        if(first.text.isEmpty() || second.text.isEmpty()){
            Toast.makeText(this,"Please enter both numbers",Toast.LENGTH_LONG).show()
            return ""
        }

        val result : Float = when (operation){
            Operation.Sum -> sum()
            Operation.Subtract -> subtract()
            Operation.Multiply -> multiply()
            Operation.Divide -> divide()
        }

        val operationSymbol : Char = when(operation){
            Operation.Sum -> '+'
            Operation.Subtract -> '-'
            Operation.Multiply -> '*'
            Operation.Divide -> '/'        }

        return "${first.text} $operationSymbol ${second.text} = $result"

    }

    private fun sum():Float{
        return  first.text.toString().toFloat() + second.text.toString().toFloat()
    }

    private fun multiply():Float{
        return  first.text.toString().toFloat() * second.text.toString().toFloat()
    }

    private fun divide():Float{
        return  first.text.toString().toFloat() / second.text.toString().toFloat()
    }

    private fun subtract():Float{
        return  first.text.toString().toFloat() - second.text.toString().toFloat()
    }



    private fun runSecondActivity(operation: Operation){

        val result = calculate(operation)

        if(result.isEmpty()) return

        val intent =  Intent(this,Second::class.java)
        intent.putExtra("result", result)
        startActivity(intent)
    }



}
