package com.pdm.olmos.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import android.content.Intent

class ImcResultActivity : AppCompatActivity() {

    private lateinit var botonR: AppCompatButton
    private lateinit var tPeso: TextView
    private lateinit var rPeso:TextView
    private lateinit var dPeso: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_result)
        initComponent()
        initUI()
        initListeners()
    }

    private fun initComponent() {
        botonR = findViewById(R.id.botonR)
        tPeso = findViewById(R.id.tPeso)
        rPeso = findViewById(R.id.rPeso)
        dPeso = findViewById(R.id.dPeso)
    }

    private fun initListeners() {
        botonR.setOnClickListener{
            navigateRecalc()
        }
    }


    private fun initUI() {
        val titulo:String =intent.extras?.getString("Título").orEmpty()
        tPeso.text = titulo
        val res:String? = intent.extras?.getString("Resultado")
        rPeso.text = res.toString()
        val desc =
            intent.extras?.getString("Descripción").orEmpty()
        dPeso.text = desc
    }

    private fun navigateRecalc() {
        val intent = Intent (this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

}


