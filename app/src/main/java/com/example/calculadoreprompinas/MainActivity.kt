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




        binding.calculateButton.setOnClickListener {
            val costOfService = binding.costOfService.text.toString().toDoubleOrNull()

            if (costOfService != null) {
                calculateTipAmount(costOfService)
            } else println("Sin Nada")
        }

    }

    private fun calculateTipAmount(costOfService: Double) {
        when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> finalResult = (costOfService * 0.2)
            R.id.option_eighteen_percent -> finalResult = (costOfService * 0.18)
            else -> finalResult = (costOfService * 0.15)
        }
        binding.tipResult.text = finalResult.toString()
    }

}