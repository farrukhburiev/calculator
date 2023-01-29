package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var zero: Button
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button

    private lateinit var multiply: Button
    private lateinit var divide: Button
    private lateinit var plus: Button
    private lateinit var minus: Button
    private lateinit var point: Button
    private lateinit var clear: Button
    private lateinit var equal: Button
    private lateinit var backpace: Button
    private lateinit var plus_minus :Button


    private lateinit var question: TextView
    private lateinit var solution: TextView

    private var isPoint = true
    private var ozgaruvchi = 0f

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        id_reg()


        zero.setOnClickListener(this)
        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)
        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        nine.setOnClickListener(this)
        clear.setOnClickListener(this)
        point.setOnClickListener(this)
        plus.setOnClickListener(this)
        minus.setOnClickListener(this)
        divide.setOnClickListener(this)
        multiply.setOnClickListener(this)
        backpace.setOnClickListener(this)
        equal.setOnClickListener(this)
        plus_minus.setOnClickListener(this)

       plus_minus.setOnClickListener {
         question.text ="("+ plus_minus().toString()+")"
       }

        point.setOnClickListener {
            if (isPoint) {
                question.text = question.text.toString() + "."
                isPoint = false
            } else question.text = question.text.toString() + ""
        }
        multiply.setOnClickListener {
            is_symbol("*")
        }
        divide.setOnClickListener {
            is_symbol("/")
        }
        plus.setOnClickListener {
            is_symbol("+")
        }
        minus.setOnClickListener {
            is_symbol("-")
        }
        clear.setOnClickListener {
            question.text = "0"
            solution.text = "0"
            isPoint = true
            ozgaruvchi = 0f
        }

        equal.setOnClickListener {

        }
        backpace.setOnClickListener {
            if (question.text.length==1){
                question.text = "0"
                solution.text = "0"
            }
           else{ question.text = question.text.dropLast(1).toString()
            solution.text = calculate()
           }
        }
    }

    private fun calculate():String {
        var list = divide_multiply(arr_creation(question.text.toString()))
        var string = ""
        var old = 0f
        var keyngi = 0f

        var i = 0
        var res = 0f
        while (list.contains('+') || list.contains('-')) {
            if (list[i] == '+' || list[i] == '-') {
                old = list[i - 1] as Float
                keyngi = list[i + 1] as Float
                var amal = list[i]
                when (amal) {
                    '+' -> {
                        res = old + keyngi
                    }
                    '-' -> {
                        res = old - keyngi
                    }
                }
                list.set(i - 1, res)

                list.removeAt(i)
                list.removeAt(i)
                i -= 2

            }
            i++
        }

        return list.joinToString()
    }


    private fun divide_multiply(list: MutableList<Any>): MutableList<Any> {
        var old = 0f
        var keyngi = 0f

        var i = 0
        var res = 0f
        while (list.contains('/') || list.contains('*')) {
            if (list[i] == '*' || list[i] == '/') {
                old = list[i - 1] as Float
                keyngi = list[i + 1] as Float
                var amal = list[i]
                when (amal) {
                    '/' -> {
                        res = old / keyngi
                    }
                    '*' -> {
                        res = old * keyngi
                    }
                }
                list.set(i - 1, res)
                list.removeAt(i)
                list.removeAt(i)
                i -= 2

            }
            i++
        }
        Log.d("AAA", list.toString())
        return list
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        val btn = findViewById<Button>(v!!.id)
        if (question.text == "0") {
            question.text = ""
        }
        question.text = question.text.toString() + btn.text
        solution.text = calculate().toString()

    }

    private fun plus_minus():Float{
        ozgaruvchi*=-1

        return ozgaruvchi
    }
    private fun arr_creation(s: String): MutableList<Any> {
        var list = mutableListOf<Any>()
        var temp = ""
        for (i in s) {
            if (i.isDigit() || i == '.') {
                temp += i
            } else {
                list.add(temp.toFloat())
                list.add(i)
                temp = ""
            }

        }

        ozgaruvchi = temp.toFloat()
        list.add(ozgaruvchi)
        return list

    }

    private fun is_symbol(char: String) {

        if (question.text.endsWith("*") || question.text.endsWith("/") || question.text.endsWith("+") || question.text.endsWith(
                "-"
            )
        ) {
            question.text = question.text.dropLast(1).toString() + char
            isPoint = true
        } else question.text = question.text.toString() + char
    }

    private fun id_reg() {
        zero = findViewById(R.id.zero)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        clear = findViewById(R.id.delete_all)
        plus = findViewById(R.id.add)
        divide = findViewById(R.id.divide)
        minus = findViewById(R.id.seperation)
        multiply = findViewById(R.id.multiply)
        equal = findViewById(R.id.equal)
        point = findViewById(R.id.point)
        backpace = findViewById(R.id.backpace)
        plus_minus = findViewById(R.id.plus_minus)
        question = findViewById(R.id.question)
        solution = findViewById(R.id.solution)


    }
}






