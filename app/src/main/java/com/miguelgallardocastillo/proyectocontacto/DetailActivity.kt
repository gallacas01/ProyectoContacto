package com.miguelgallardocastillo.proyectocontacto

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.miguelgallardocastillo.proyectocontacto.databinding.DetailActivityBinding

class DetailActivity : AppCompatActivity() {

    //El valor de esta constante es estática.
    companion object{
        const val EXTRA_CONTACTO = "EXTRA_CONTACTO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflamos la vista del layout que hemos creado en segundo lugar.
        val binding = DetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contacto = intent?.getParcelableExtra<Contacto>(EXTRA_CONTACTO) ?: throw
        IllegalStateException()

        binding.textView.text = contacto?.nombre
        //Con el método que extiende de ImageView.
        binding.imageView.glide(contacto.imagen)
        //Con el glide.
        //Glide.with(binding.imageView).load(contacto.imagen).into(binding.imageView)


        binding.button1.setOnClickListener{
            val telIntent =  Intent(Intent.ACTION_DIAL, android.net.Uri.parse("tel:" + contacto.tel))
            if (intent.resolveActivity(packageManager) != null){ //Comprobamos que el dispositivo tiene un gestor de correos instalado.
                startActivity(telIntent)
            }
        }

        binding.button2.setOnClickListener{

            val uri = Uri.parse("mailto:" + contacto.correo)
            val emailIntent = Intent(
                Intent.ACTION_SENDTO, uri
            )
            startActivity(emailIntent)
        }



    }
}