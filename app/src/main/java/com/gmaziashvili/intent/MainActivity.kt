package com.gmaziashvili.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        calcualate.setOnClickListener { runSecondActivity() }



        ArrayAdapter.createFromResource(
            this,
            R.array.operations,
            android.R.layout.simple_spinner_item
        ).also { adapter ->

            operation.adapter = adapter
        }


    }


    private fun add():Float{
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



    private fun runSecondActivity(){

        var result : Float = 0F


        val operation = operation.selectedItem.toString()

        when(operation){
            "*" -> { result = multiply() }
            "/" -> { result = divide() }
            "+" -> { result = add() }
            "-" -> { result = subtract() }
        }

        val intent =  Intent(this,Second::class.java)
        intent.putExtra("result", result.toString())
        startActivity(intent)
    }



}
