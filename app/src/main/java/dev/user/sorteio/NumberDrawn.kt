package dev.user.sorteio

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dev.user.sorteio.databinding.ActivityNumberDrawnBinding

class NumberDrawn : AppCompatActivity(), View.OnClickListener {

    private  lateinit var binding: ActivityNumberDrawnBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNumberDrawnBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.hide()

        numeroSorteado()

        binding.ivVolta.setOnClickListener(this)

    }
    override fun onClick(view: View) {
        if(view.id == R.id.iv_volta){
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
    fun numeroSorteado() {

        var numeroSorteado = intent.getStringExtra("numeroAleatorio")
        binding.tvNumero.text = numeroSorteado.toString()

    }

}