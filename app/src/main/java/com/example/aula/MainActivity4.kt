package com.example.aula

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity4 : AppCompatActivity() {

    lateinit var numDigi : TextView
    lateinit var historico : TextView
    lateinit var anterior : TextView
    lateinit var btSoma : Button
    lateinit var btSub : Button
    lateinit var btMult : Button
    lateinit var btDiv : Button
    lateinit var btApaga : Button
    var valor1 = 0.0
    var valor2 = 0.0
    var resultado = 0.0
    var operador = ""
    var flagOperando = false
    var aux = 0
    var flagPonto = false
    var vazio = true
    var memoria = ""
    var flagIgual = false
    var tamanho = 0
    var  auxString = ""
    var num = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)


        numDigi = findViewById<EditText>(R.id.editTextNumberDecimal10)
        historico = findViewById<TextView>(R.id.textView6)
        anterior = findViewById<TextView>(R.id.textView7)
        historico.setText((0).toString())
        numDigi.setText("0")
        btSoma = findViewById<Button>(R.id.buttonmais)
        btSub = findViewById<Button>(R.id.buttonmenos)
        btMult = findViewById<Button>(R.id.buttonmultiplica)
        btDiv = findViewById<Button>(R.id.buttondividi)
        btApaga = findViewById<Button>(R.id.buttonapaga)


    }

    fun OnClickC(view: View) {
        flagPonto = false
        if(historico.getText().toString() == "0")
        {
            anterior.text = ""
        }
        if (numDigi.getText().toString() == "0") {
            historico.setText("0").toString()
            resultado = 0.0
            valor1 = 0.0
            memoria = ""
            operador = ""
            vazio = true
        }
        else {
            if(flagOperando) {
                operador = ""
                flagOperando = false
                aux = historico.length()
                historico.setText(historico.text.substring(0,aux-1))
            }
            else {
                historico.text.indexOf(numDigi.toString())
                numDigi.setText("0")
                memoria = ""
            }
        }

        MudarCor()
    }
    fun OnClickMaisMenos(view: View) {
        if (numDigi.getText().toString() != "")
        {
            val num = numDigi.text.toString().toDouble()
            val resultado= num * (-1)
            numDigi.setText(resultado.toString())
        }
    }
    fun OnClickApaga(view: View) {
        if(flagOperando)
        {
            tamanho = historico.length()
            auxString = historico.text.substring(0, (tamanho - 1))
            historico.setText(auxString).toString()
            vazio = true
            operador = ""
            flagOperando = false

            MudarCor()
        }

        else {
            if (numDigi.getText().toString() != "0" && numDigi.getText().toString() != "") {

                tamanho = numDigi.length()
              //  if (numDigi.text.substring((tamanho - 1), tamanho) == ".")
                if (numDigi.text[numDigi.text.length-1] == '.')
                    flagPonto = false
                auxString = numDigi.text.substring(0, (tamanho - 1))
                numDigi.setText(auxString).toString()
            }

            if(historico.length()!=0) {
                tamanho = historico.length()
                auxString = historico.text.substring(0, (tamanho - 1))
                historico.setText(auxString).toString()
            }
        }
    }
    fun OnClickDividi(view: View) {
        if (!flagOperando) {
            flagIgual = false
            flagOperando = true
            /* when(historico.text.substring(historico.length()-1))
         {
             "-" -> historico.text = historico.text.substring(0,historico.length()-1)+operador
             "+" -> historico.text = historico.text.substring(0,historico.length()-1)+operador
             "*" -> historico.text = historico.text.substring(0,historico.length()-1)+operador
             "/" -> historico.text = historico.text.substring(0,historico.length()-1)+operador
             else -> historico.text = historico.text.toString() + operador
         }*/
            Igual()
            operador = "/"
            historico.text = historico.text.toString() + operador

            MudarCor()
        }
        else{
            btApaga.callOnClick()
            btDiv.callOnClick()
        }
    }
    fun OnClickMultiplica(view: View) {
        if (!flagOperando) {
            flagIgual = false
            flagOperando = true
            Igual()
            operador = "*"
            historico.text = historico.text.toString() + operador

            MudarCor()
        }
        else{
            btApaga.callOnClick()
            btMult.callOnClick()
        }
    }
    fun OnClickSubtracao(view: View) {
        if (!flagOperando) {
            flagIgual = false
            flagOperando = true
            Igual()
            operador = "-"
            historico.text = historico.text.toString() + operador

            MudarCor()
        }
        else{
            btApaga.callOnClick()
            btSub.callOnClick()
        }
    }
    fun OnClickSoma(view: View) {
        if (!flagOperando) {
            flagIgual = false
            flagOperando = true
            Igual()
            operador = "+"
            historico.text = historico.text.toString() + operador

            MudarCor()

            //btSoma.setBackgroundColor(resources.getColor(R.color.purple_200))
           //btSub.setBackgroundColor(resources.getColor(R.color.purple_500))
           // btMult.setBackgroundColor(resources.getColor(R.color.purple_500))
           // btDiv.setBackgroundColor(resources.getColor(R.color.purple_500))
        }
        else{
            btApaga.callOnClick()
            btSoma.callOnClick()
        }
    }
    fun OnClickPonto(view: View) {


        if (!flagPonto) {
            flagPonto = true
            if(vazio) {
                if (numDigi.getText().toString() == "0") {
                    numDigi.setText("0.")
                } else {
                    numDigi.text = numDigi.text.toString() + "."
                }
            }
            else
            {
                if (numDigi.getText().toString() == "0") {
                    numDigi.setText("0.")
                } else {
                    numDigi.text = numDigi.text.toString() + "."
                }
            }

            if (historico.getText().toString() == "0") {
                historico.setText("0.")
           }
            else{
                historico.text = historico.text.toString() + "."
            }
        }
        else {
            tamanho = historico.length()
            if (historico.text.substring((tamanho-1),tamanho)==".")
            flagPonto = true
            else {
                historico.text = historico.text.toString() + "."
                memoria = memoria + "."
                flagPonto = true
            }
        }
    }
    fun OnClickIgual(view: View) {
        if(!flagOperando){
            if(!flagIgual) {
                Igual()
                flagIgual = true
                vazio = true

            }
            else
            {
                anterior.text =historico.text.toString() + "=" + resultado.toString()
                numDigi.text = "0"
                historico.text = "0"
                resultado = 0.0
                vazio = true
               // memoria = historico.toString()
              //  resultado = memoria.toDouble()
             //   valor1 = resultado
                flagIgual = false
                operador = ""
                flagPonto = false
                flagOperando = false
            }
        }
    }
    fun OnClickZero(view: View) {
        if(vazio)
        {
            if (numDigi.getText().toString() != "0") {
                numDigi.text = numDigi.text.toString() + "0"
            }
        }
        else {
            if (memoria != "0") {
                memoria +=  "0"
            }
        }

        if(historico.text != "0")
        {
            historico.text = historico.text.toString() + "0"
        }
        flagOperando = false

    }
    fun OnClickUm(view: View) {
        num = 1
        MudarNumero()
    }
    fun OnClickDois(view: View) {
        num = 2
        MudarNumero()
    }
    fun OnClickTres(view: View) {
        num = 3
        MudarNumero()
    }
    fun OnClickQuatro(view: View) {
        num = 4
        MudarNumero()
    }
    fun OnClickCinco(view: View) {
        num = 5
        MudarNumero()
    }
    fun OnClickSeis(view: View) {
        num = 6
        MudarNumero()
    }
    fun OnClickSete(view: View) {
        num = 7
        MudarNumero()
    }
    fun OnClickOito(view: View) {
        num = 8
        MudarNumero()
    }
    fun OnClickNove(view: View) {
        num = 9
        MudarNumero()
    }
    fun MudarNumero(){
        if(vazio) {
            if (numDigi.getText().toString() != "0") {
                numDigi.text = numDigi.text.toString() + num.toString()
            }
            else
            {
                numDigi.text = num.toString()
            }
        }
        else
        {
            if(memoria=="0")
                memoria = num.toString()
            else
                memoria += num.toString()
        }

        if(historico.text != "0")
        {
            historico.text = historico.text.toString() + num.toString()
        }
        else
        {
            historico.text = num.toString()
        }
        flagOperando = false

    }
    fun MudarCor() {
        var botao = btMult
        btSoma.setBackgroundColor(resources.getColor(R.color.purple_500))
        btSub.setBackgroundColor(resources.getColor(R.color.purple_500))
        btMult.setBackgroundColor(resources.getColor(R.color.purple_500))
        btDiv.setBackgroundColor(resources.getColor(R.color.purple_500))
        when(operador) {
            "+" -> botao = btSoma
            "-" -> botao = btSub
            "*" -> botao = btMult
            "/" -> botao = btDiv

        }
        if(flagOperando==true)
            botao.setBackgroundColor(resources.getColor(R.color.purple_200))
    }
    fun Igual(){

        if (vazio) {
            memoria = numDigi.text.toString()
            resultado = memoria.toDouble()
            valor1 = resultado
            vazio = false
            if (operador == "/" || operador == "*")
                valor2 = 1.0
        } else {
            valor1 = resultado
            valor2 = memoria.toDouble()
        }
        when (operador) {
            "+" -> resultado = valor1 + valor2
            "-" -> resultado = valor1 - valor2
            "*" -> resultado = valor1 * valor2
            "/" -> {
                if(valor2!=0.0)
                    resultado = valor1 / valor2
                else{
                    Snackbar.make(numDigi,"Impossível Dividir por 0",Snackbar.LENGTH_LONG).show()
                   // OnClickApaga(numDigi)
                    btApaga.callOnClick()
                    flagIgual = false
                    flagOperando = true

                    btApaga.callOnClick()
                   // OnClickApaga()
                    btApaga.callOnClick()
                }

            }
        }
        if(resultado==resultado.toInt().toDouble())
            numDigi.text = resultado.toInt().toString()
        else
            numDigi.text = resultado.toString()
        memoria = ""
        operador = ""

        MudarCor()
    }


    //Layout botão pequeno
    // Não deixa alterar a cor
    // @style/Widget.AppCompat.Button.Small

}