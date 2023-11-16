package com.pdm.olmos.imcapp

import android.content.Intent
import android.icu.text.DecimalFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.get
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider


class ImcCalculatorActivity : AppCompatActivity() {
    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var addP: FloatingActionButton
    private lateinit var removeP: FloatingActionButton
    private lateinit var addE: FloatingActionButton
    private lateinit var removeE: FloatingActionButton
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var weight: TextView
    private lateinit var age: TextView
    private lateinit var calcula: FloatingActionButton


    private var dWeight: Double = 40.0
    private var iAge: Int = 18

    private var isMale = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()
        initUI()

    }

    fun initComponents(){
        calcula = findViewById(R.id.calcula)
        viewMale = findViewById(R.id.male)
        viewFemale = findViewById(R.id.female)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        addP = findViewById(R.id.addP)
        addE = findViewById(R.id.addE)
        removeP = findViewById(R.id.removeP)
        removeE = findViewById(R.id.removeE)
        weight = findViewById(R.id.weight)
        age = findViewById(R.id.age)


    }

    fun initListeners(){

        viewMale.setOnClickListener { isMale = true

        }
        viewFemale.setOnClickListener { isMale = false }

        rsHeight.addOnChangeListener { _, value, _ ->
            tvHeight.text = value.toString()
            tvHeight.text = DecimalFormat("#.##").format(value) + " cm"

            val df=DecimalFormat("#.##")
            val res = df.format(value)
            tvHeight.text=res


        }

        addP.setOnClickListener{
            dWeight = dWeight + 1

            setWeight()

        }

        addE.setOnClickListener{
            dWeight = dWeight + 1

            setWeight()

        }

        removeP.setOnClickListener{
            dWeight = dWeight - 1

            setWeight()

        }

        removeE.setOnClickListener{
            dWeight = dWeight - 1

            setWeight()

        }

        calcula.setOnClickListener{


        }



    }

   fun getBackgroundColor(v:Boolean):Int{


       val colorReference = if(v) {
           R.color.bg_comp_sel
       } else {
           R.color.bg_comp
       }


       return ContextCompat.getColor(this,colorReference)

    }


    fun setGenderColor(){

        viewMale.setCardBackgroundColor(getBackgroundColor(isMale))
        viewFemale.setCardBackgroundColor(getBackgroundColor(!isMale))
    }

    fun initUI(){

        setGenderColor()
        setWeight()
        setAge()

    }

    private fun setWeight() {
        weight.text = dWeight.toString()
    }

    private fun setAge() {
        age.text = iAge.toString()
    }


    fun calculateIMC():Double{

        var peso: Double =weight.text.toString().toDouble();
        var altura= tvHeight.text.toString().toDouble()
        altura = (altura / 100) * altura
        var res: Double = peso / (altura);


        return res;

    }

    fun navigate2result(res:Double){

        val intentGA = Intent(this, ImcResultActivity::class.java)
        intentGA.putExtra("Resultado", res)
        startActivity(intentGA)


    }


}