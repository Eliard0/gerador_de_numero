package dev.user.sorteio

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

            if(min != 0 && max != 0) {
                var numeroAleatorio = Math.random() * ((max - min) + 1)

                binding.aleatorio.text = "numero aleatorio ${numeroAleatorio.roundToInt()}"
            }else{
                Toast.makeText(this, "Os dois números tem que ser diferente de 0", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Algo deu errado", Toast.LENGTH_LONG).show()
        }
    }
}