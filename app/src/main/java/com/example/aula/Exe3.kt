package com.example.aula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class Exe3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exe3)
    }

    fun OnClickCalcular(view: View) {
        val spinner = findViewById<Spinner>(R.id.spinner)
        //val opr = spinner.selectedItem.toString()
        val textView = findViewById<TextView>(R.id.textView3)
        val valor1 = findViewById<EditText>(R.id.editTextNumberDecimal).text.toString().toDouble()
        val valor2 = findViewById<EditText>(R.id.editTextNumberDecimal2).text.toString().toDouble()

        var result = 0.0

        val opr = spinner.selectedItem.toString()

        //if (opr == "Soma") {
      //      result = valor1 + valor2
      //  } else if (opr == "Subtração") {
        //    result = valor1 - valor2
      //  } else if (opr == "Multiplicaão") {
       //     result = valor1 * valor2
      //  } else if (opr == "Divisão") {
            //result = valor1 / valor2
    //    }
   when(opr){
       "Soma"->result=valor1+valor2
       "Subtração"->result=valor1-valor2
       "Multiplicação"->result=valor1*valor2
       "Divisão"->result=valor1/valor2
   }

        textView.setText(result.toString())
    }
}