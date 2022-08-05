package com.example.calculadoreprompinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadoreprompinas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var finalResult = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


       val costOfService = binding.costOfService.text.toString().toDoubleOrNull()

        binding.calculateButton.setOnClickListener {

            if (costOfService != null) {
                calculateTipAmount(costOfService)
            }
            else "Sin Nada"
        }



    }

    private fun calculateTipAmount(costOfService:Double) {
        if (binding.optionTwentyPercent.isActivated) {
            finalResult = (costOfService * 0.2)
        } else if (binding.optionEighteenPercent.isActivated) {
            finalResult = (costOfService * 0.18)
        } else {
            finalResult = (costOfService * 0.15)
        }
        binding.tipResult.text = finalResult.toString()
    }


}



