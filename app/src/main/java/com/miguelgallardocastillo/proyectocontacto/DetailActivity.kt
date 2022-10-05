package com.miguelgallardocastillo.proyectocontacto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.miguelgallardocastillo.proyectocontacto.databinding.ActivityMainBinding
import com.miguelgallardocastillo.proyectocontacto.databinding.DetailActivityBinding

class DetailActivity : AppCompatActivity() {

    //El valor de esta constante
    companion object{
        const val EXTRA_CONTACTO = "contacto_eviado"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflamos la vista del layout que hemos creado en segundo lugar.
        val binding = DetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val contacto = intent?.getParcelableExtra<Contacto>(EXTRA_CONTACTO) ?: throw
        IllegalStateException()
        binding.textView.text = contacto.nombre
        Glide.with(binding.imageView).load(contacto.imagen).into(binding.imageView)

    }
}