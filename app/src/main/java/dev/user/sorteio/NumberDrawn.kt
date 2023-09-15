package dev.user.sorteio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.user.sorteio.databinding.ActivityNumberDrawnBinding

class NumberDrawn : AppCompatActivity() {

    private  lateinit var binding: ActivityNumberDrawnBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNumberDrawnBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.hide()

     numeroSorteado()

    }

    fun numeroSorteado() {

        var numeroSorteado = intent.getStringExtra("numeroAleatorio")
        binding.tvNumero.text = numeroSorteado.toString()

    }
}