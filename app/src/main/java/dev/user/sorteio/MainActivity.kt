package dev.user.sorteio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import dev.user.sorteio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btInicia.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.bt_inicia) {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
}