package com.example.bmicalulator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bmicalulator.databinding.ActivityMainBinding
import java.math.BigDecimal
import kotlin.math.roundToLong


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var heightValue: Double = 0.0
    private var weightValue: Double = 0.0
    private var bmi: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Reference the height input field and assign it to a variable
        val heightEt = binding.heightEt

        /*
        set a click listener to the height increment button that when clicked increases
       the value in the input field by 1
        */
        binding.heightPlusBtn.setOnClickListener {
            if (heightEt.text.toString().isNotEmpty()) {
                heightValue = heightEt.text.toString().toDouble()
            }
            heightValue++
            heightEt.setText(heightValue.toString())
        }

        /*
        set a click listener on the height decrement button that when clicked decreases
        the value in the input field by 1
        */
        binding.heightMinusBtn.setOnClickListener {
            if (heightEt.text.toString().isNotEmpty()) {
                heightValue = heightEt.text.toString().toDouble()
            }
            heightValue--
            heightEt.setText(heightValue.toString())
        }



        // Reference the weight input field and assign it to a variable
        val weightEt = binding.weightEt

        /*
        set a click listener to the weight increment button that when clicked increases
       the value in the input field by 1
        */
        binding.weightPlusBtn.setOnClickListener {
            if (weightEt.text.toString().isNotEmpty()) {
                weightValue = weightEt.text.toString().toDouble()
            }
            weightValue++
            weightEt.setText(weightValue.toString())
        }

        /*
        set a click listener on the weight decrement button that when clicked decreases
        the value in the input field by 1
        */
        binding.weightMinusBtn.setOnClickListener {
            if (weightEt.text.toString().isNotEmpty()) {
                weightValue = weightEt.text.toString().toDouble()
            }
            weightValue--
            weightEt.setText(weightValue.toString())
        }

        binding.calculateBtn.setOnClickListener {
            val height = heightEt.text.toString().toDouble()
            val weight = weightEt.text.toString().toDouble()
            bmi =(weight/height.times(height))
            //Toast.makeText(this,"$bmi",Toast.LENGTH_LONG).show()
            displayBMIResult(bmi)
        }

    }


    @SuppressLint("StringFormatMatches")
    private fun displayBMIResult(bmi: Double) {
        var bmiLabel = ""
        var bmiDescription = ""
        when {
            bmi < 18.5 -> {
                bmiLabel = "Mrsav si ka igla"
                bmiDescription = "Jedi bre sve sto stignes, manje seksa vise 'rane"
            }
            bmi in 18.51..24.9 -> {
                bmiLabel = "Normalan"
                bmiDescription = "Bravo pravi si macak, ako nisi zenjen ostani slobodan!"
            }
            bmi in 24.91..29.99 -> {
                bmiLabel = "Preliva"
                bmiDescription = "Covjece setaj malo, pusti TV i kafu, dizi dupe!"
            }
            bmi >= 30.0 -> {
                bmiLabel = "Dobro utovljeno celjade"
                bmiDescription = "Jaci si od trokrilnog frizidera, ako se ne pokrenes ima uskoro da te nema.."
            }
        }
        val bmiValue = Math.round(bmi.toDouble() * 100) / 100.0
        // A This is used to access a String's value from the
        // Activity class.

        binding.resultTv.text = "Tvoj BMI rezultat je "+bmiValue+"\n"+bmiLabel+"\n"+bmiDescription
    }


}