package com.example.aula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivityExe2 : AppCompatActivity() {

    lateinit var etn1 : EditText
    lateinit var etn2 : EditText
    lateinit var tvRes : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_exe2)

         etn1 = findViewById<EditText>(R.id.editTextTextPersonName)
         etn2 = findViewById<EditText>(R.id.editTextTextPersonName3)
        tvRes = findViewById<TextView>(R.id.textView)

    }

    fun OnClickDiv(view: View) {
        val n1 = etn1.text.toString().toDouble()
        val n2 = etn2.text.toString().toDouble()
        val res = n1/n2
        tvRes.setText(res.toString())
    }


    fun OnClickMult(view: View) {
        val n1 = etn1.text.toString().toDouble()
        val n2 = etn2.text.toString().toDouble()
        val res = n1*n2
        tvRes.setText(res.toString())
       // tvRes.setText((n1*n2).toString())
    }


    fun OnClickSum(view: View) {
        val n1 = etn1.text.toString().toDouble()
        val n2 = etn2.text.toString().toDouble()
        val res = n1+n2
        tvRes.setText(res.toString())
    }


    fun OnClickSub(view: View) {
        val n1 = etn1.text.toString().toDouble()
        val n2 = etn2.text.toString().toDouble()
        val res = n1-n2
        tvRes.setText(res.toString())
    }
}
