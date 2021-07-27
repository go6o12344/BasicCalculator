package com.example.basiccalculator

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        var currVal = 0.0;
        var currOp = ""

        val e = findViewById<EditText>(R.id.editText)

        val l = {b : Button -> b.setOnClickListener{
            if("${e.text}".equals("0"))
                e.setText(b.text)
            else
                e.setText("${e.text}${b.text}")
        }}

        val b0 = findViewById<Button>(R.id.button0)
        b0.setOnClickListener{
            if(!"${e.text}".equals("0"))
                e.setText("${e.text}${b0.text}")

        }
        val b1 = findViewById<Button>(R.id.button1)
        l(b1)

        val b2 = findViewById<Button>(R.id.button2)
        l(b2)

        val b3 = findViewById<Button>(R.id.button3)
        l(b3)

        val b4 = findViewById<Button>(R.id.button4)
        l(b4)

        val b5 = findViewById<Button>(R.id.button5)
        l(b5)

        val b6 = findViewById<Button>(R.id.button6)
        l(b6)

        val b7 = findViewById<Button>(R.id.button7)
        l(b7)

        val b8 = findViewById<Button>(R.id.button8)
        l(b8)

        val b9 = findViewById<Button>(R.id.button9)
        l(b9)

        val bdot = findViewById<Button>(R.id.dotButton)
        bdot.setOnClickListener{
            if(!e.text.contains('.'))
                e.setText("${e.text}${bdot.text}")
        }

        val bcls = findViewById<Button>(R.id.clearButton)
        bcls.setOnClickListener {
            e.setText("")
            currOp = ""
            e.setHint("0")
            currVal = 0.0
        }

        val setval = {op: String ->

            val x = e.text.toString().toDoubleOrNull() ?: 0.0
            when (op) {
                "" -> currVal = x
                "add" -> currVal += x
                "sub" -> currVal -= x
                "mul" -> currVal *= x
                "div" -> currVal /= x
            }
            var h = currVal.toString()
            if(h.contains('.') && h.last() == '0')
                h = h.subSequence(0, h.length - 2).toString()
            e.setHint(h)

        }

        val badd = findViewById<Button>(R.id.addButton)
        badd.setOnClickListener {
            setval(currOp)
            currOp = "add"
            e.setText("")
        }

        val bsub = findViewById<Button>(R.id.subtractButton)
        bsub.setOnClickListener {
            if(e.text.isNullOrEmpty())
                e.setText("-")
            else if(!"${e.text}".equals("-")) {
                setval(currOp)
                currOp = "sub"
                e.setText("")
            }
        }
        val bmul = findViewById<Button>(R.id.multiplyButton)
        bmul.setOnClickListener {
            setval(currOp)
            currOp = "mul"
            e.setText("")
        }

        val bdiv = findViewById<Button>(R.id.divideButton)
        bdiv.setOnClickListener {
            setval(currOp)
            currOp = "div"
            e.setText("")
        }

        val beq = findViewById<Button>(R.id.equalButton)
        beq.setOnClickListener {
            setval(currOp)
            currOp = ""
            var t = currVal.toString()
            if(t.contains('.') && t.last() == '0')
                t = t.subSequence(0, t.length - 2).toString()
            e.setText(t)
        }



    }
}