package dev.user.sorteio

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import dev.user.sorteio.databinding.ActivityHomeBinding
import kotlin.math.roundToInt

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityHomeBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btGerar.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.bt_gerar) {
            gerandoNumeroAleatorio()
        }
    }

    fun validaNumeros(): Boolean {
        return (
                binding.editTextInicio.text.toString() != "" && binding.editTextFim.text.toString() != ""
                )
    }

    fun gerandoNumeroAleatorio() {
        if (validaNumeros()) {
            var min = binding.editTextInicio.text.toString().toInt()
            var max = binding.editTextFim.text.toString().toInt()

            if(min >= 0 && max > min) {
                var numeroAleatorio = Math.random() * (max - min)

                val intent = Intent(this, NumberDrawn::class.java)
                intent.putExtra("numeroAleatorio", numeroAleatorio.roundToInt().toString())
                startActivity(intent)
            }else{
                Snackbar.make(binding.layoutRoot, getString(R.string.instrucao_um), Snackbar.LENGTH_LONG).show()
            }
        } else {
            Snackbar.make(binding.layoutRoot, getString(R.string.instrucao_dois), Snackbar.LENGTH_LONG).show()
        }
    }
}