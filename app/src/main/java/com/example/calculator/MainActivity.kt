package com.example.calculator

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var one:Button
    lateinit var two:Button
    lateinit var three:Button
    lateinit var four:Button
    lateinit var five:Button

    lateinit var question : TextView
    lateinit var solution : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)

        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        question.setVisibility(TextView.VISIBLE)
        when(v?.getId()){
            R.id.one -> Toast.makeText(this,"one",Toast.LENGTH_SHORT).show()
            R.id.two -> Toast.makeText(this,"two",Toast.LENGTH_SHORT).show()
            R.id.three -> Toast.makeText(this,"three",Toast.LENGTH_SHORT).show()
            R.id.four -> Toast.makeText(this,"four",Toast.LENGTH_SHORT).show()
            R.id.five -> Toast.makeText(this,"five",Toast.LENGTH_SHORT).show()
        }
    }


}