package com.miguelgallardocastillo.proyectocontacto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miguelgallardocastillo.proyectocontacto.databinding.ViewContactoItemBinding


class ContactoAdapter (val contacto: List<Contacto>, val listener: (Contacto) -> Unit) : RecyclerView.Adapter<ContactoAdapter.ViewHolder>() {

    //Crear una nueva vista cuando el adapter se lo diga.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Inflamos la vista.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_contacto_item,parent,false)
        return ViewHolder(view)
    }

    //Actualizar una vista cuando el adapter se lo diga.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val contactoActual = contacto[position]
        holder.bind(contactoActual)
        //El click se hace sobre la vista, que está contenida en el viewHolder.
            holder.itemView.setOnClickListener{
            listener(contactoActual)
        }
    }

    //Devuelve el número de elementos de la lista que pasa como parámetro.
    override fun getItemCount(): Int {
        return contacto.size
    }

    //Si queremos cargar distintos tipos de vista, se lo diremos al Recyclerview cuál cargar en función de su posición.
    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class ViewHolder (private val view: View): RecyclerView.ViewHolder(view){

        //Este binding hace referencia a la vista que se le pasa como parámetro.
        val binding = ViewContactoItemBinding.bind(view)

        fun bind(contacto: Contacto){
            binding.nombreContacto.text = contacto.nombre
            binding.telContacto.text = contacto.tel
            binding.emailContacto.text = contacto.correo
            binding.apply { imagenContacto.glide(contacto.imagen) }
        }

    }

}

fun ImageView.glide(url: String){
    Glide.with(this).load(url).into(this)

}