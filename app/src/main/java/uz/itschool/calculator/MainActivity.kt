package uz.itschool.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import kotlin.math.min

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button
    private lateinit var zero: Button
    private lateinit var point: Button
    private lateinit var c: Button
    private lateinit var delete_last: Button
    private lateinit var kopaytiruv: Button
    private lateinit var boluv: Button
    private lateinit var foiz: Button
    private lateinit var qavs_minus: Button
    private lateinit var minus: Button
    private lateinit var plus: Button
    private lateinit var teng: Button
    private lateinit var operand: TextView
    private lateinit var result: TextView

    private var ispoint = true
    private var isdigit = false


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        six = findViewById(R.id.six)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        foiz = findViewById(R.id.foiz)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)
        point = findViewById(R.id.point)
        boluv = findViewById(R.id.boluv)
        kopaytiruv = findViewById(R.id.kopaytiruv)
        qavs_minus = findViewById(R.id.qavs_minus)
        c = findViewById(R.id.c)
        delete_last = findViewById(R.id.delete_last)
        plus = findViewById(R.id.plus)
        minus = findViewById(R.id.minus)
        teng = findViewById(R.id.teng)
        operand = findViewById(R.id.operand)
        result = findViewById(R.id.result)

        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)
        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        nine.setOnClickListener(this)
        zero.setOnClickListener(this)
        point.setOnClickListener { addpoint() }

        plus.setOnClickListener { addSimvol(plus.text.toString()) }
        minus.setOnClickListener { addSimvol(minus.text.toString()) }
        kopaytiruv.setOnClickListener { addSimvol(kopaytiruv.text.toString()) }
        boluv.setOnClickListener { addSimvol(boluv.text.toString()) }
        teng.setOnClickListener { list(operand.text.toString()) }
        qavs_minus.setOnClickListener {manfiySon(operand.text.length) }


    }


    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        val btn = findViewById<Button>(view!!.id)

        if (operand.text != "0") {
            operand.text = operand.text.toString() + btn.text

            isdigit = true
            ispoint = true
        } else {
            operand.text = btn.text
            ispoint = true
            isdigit = true

        }
        Log.d("digit",isdigit.toString())
    }

    @SuppressLint("SetTextI18n")
    fun addpoint() {
        if (isdigit) {
            operand.text = operand.text.toString() + point.text
            isdigit=false
            Log.d("isdigit", isdigit.toString())
        }
    }

    @SuppressLint("SetTextI18n")
    fun addSimvol(simvol: String) {
        if (isdigit) {
            operand.text = operand.text.toString() + simvol
            isdigit=false

        } else {
            if (operand.text != "0") {
                operand.text = operand.text.dropLast(1)
                    .toString() + simvol
                isdigit=false
            }
        }
        ispoint = true
        Log.d("isdigit",isdigit.toString())

    }

    fun list(s:String) {
        val list = mutableListOf<Any>()
        var temp = ""
        for (i in s) {
            if (i.isDigit() || i.equals(".")) {
                temp += i
            } else {
                list.add(temp)
                list.add(i)
                temp = ""
            }
        }
        if (temp.isNotEmpty()) {
            list.add(temp)
        }

        Log.d("list", list.toString())
    }


    fun manfiySon(s: Int) {

//        val list = mutableListOf<Any>()
//        var temp = ""
//        for (i in operand.text) {
//            if (i.isDigit() or i.equals(".")) {
//                temp += i
//            } else {
//                list.add(i)
//                list.add(temp)
//                temp = ""
//            }
//        }
//        if (temp.isNotEmpty()) {
//            list.add(temp)
//        }
//
//        Log.d("list", list.toString())
//        var lastchar = ""
//        if (isdigit) {
//            var count = 0
//            for (i in list[list.size - 1].toString()) {
//                count++
//                lastchar = ""
//                Log.d("last", list[list.size - 1].toString())
//                for (i in list[list.size - 1].toString()) {
//                    lastchar += i
//                }
//            }
//            Log.d("lastchar", lastchar)
//
//            operand.text = operand.text.dropLast(count)
//            operand.text = operand.text.toString() + "(-" + lastchar + ")"
//            Log.d("isdigit", isdigit.toString())
//
//        }
        val list = mutableListOf<Any>()
        for ( i in operand.text){
            list.add(i)
        }
        var temp = ""
        for (i in 0.. list.size-1) {
            if (list[i].toString().isDigitsOnly() or list[i].equals(".")) {
                temp += i
            }
            else if (i.equals("(")){
                list.remove(i)

            }

            }
        Log.d("list", list.toString())
//        if (temp.isNotEmpty()) {
//         list1.add(temp)
//        }

//        var lastchar = ""
//        if (isdigit) {
//            var count = 0
//            for (i in list1[list1.size - 1].toString()) {
//                count++
//                lastchar = ""
//                Log.d("last", list1[list1.size - 1].toString())
//                for (i in list1[list1.size - 1].toString()) {
//                    lastchar += i
//                }
//            }

//            operand.text = operand.text.dropLast(count)
//            operand.text = operand.text.toString() + "-"+lastchar
//            Log.d("song",list1.last().toString())

//        }
    }
    }

