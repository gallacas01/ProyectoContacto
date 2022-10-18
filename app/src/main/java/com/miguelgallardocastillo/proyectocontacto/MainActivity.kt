package com.miguelgallardocastillo.proyectocontacto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miguelgallardocastillo.proyectocontacto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //El binding está inflando la vista del activity main, que es donde se encuentra el recyclerview.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = ContactoAdapter(listOf(
            Contacto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_c8oKklgkak8-CTVMkZKFs33eNSIRaB1UHBKOksQUYAJn2l5iSzBgLhf3BIcJfzjhFH0&usqp=CAU", "Miguel Gallardo Castillo", "653789274", "miguelgc01@gmail.com"),
            Contacto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_c8oKklgkak8-CTVMkZKFs33eNSIRaB1UHBKOksQUYAJn2l5iSzBgLhf3BIcJfzjhFH0&usqp=CAU", "María Gómez López", "635790524", "correomargia@gmail.com"),
            Contacto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_c8oKklgkak8-CTVMkZKFs33eNSIRaB1UHBKOksQUYAJn2l5iSzBgLhf3BIcJfzjhFH0&usqp=CAU", "Pablo Pérez Rodríguez", "680755294", "pablocorreo@gmail.com"),
            Contacto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_c8oKklgkak8-CTVMkZKFs33eNSIRaB1UHBKOksQUYAJn2l5iSzBgLhf3BIcJfzjhFH0&usqp=CAU", "Manuela Herrera Castillo", "955728920", "correoManuela@gmail.com")
        ))
        {
            contacto ->  val intent = Intent(this@MainActivity, DetailActivity::class.java)
            //DetailActivity es la vista a la que queremos movernos cuando se produzca el evento onClickListener.

            //EXTRA_CONTACTO  es una constante con un valor predeterminado para no tener que escribirlo en el bandle cada vez.
            intent.putExtra(DetailActivity.EXTRA_CONTACTO, contacto)
            startActivity(intent);

        }



    }

}