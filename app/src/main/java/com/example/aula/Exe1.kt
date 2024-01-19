package com.example.aula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class Exe1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exe1)
    }
    fun click1(view: View) {

        // Toast.makeText(this, "Teste Btn Click", Toast.LENGTH_LONG).show()
        //Snackbar.make(this, :"tste Btn Click", Snackbar.LENGHT_LONG).show()

        val edTextNome = findViewById<EditText>(R.id.editTextTextPersonName2)
        val textViewtxt = findViewById<TextView>(R.id.textView2)

        textViewtxt.setText(edTextNome.text)
    }
}