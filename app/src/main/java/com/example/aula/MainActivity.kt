package com.example.aula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickEx1(view: View) {
        val intent = Intent(this,Exe1::class.java)
        startActivity(intent)

    }



    fun OnClickEx2(view: View) {

        val intent = Intent(this,MainActivityExe2::class.java)
        startActivity(intent)

    }

    fun OnClickEx3(view: View) {

        val intent = Intent(this,Exe3::class.java)
        startActivity(intent)

    }

    fun OnClickEx4(view: View) {

        val intent = Intent(this,MainActivity4::class.java)
        startActivity(intent)

    }


}