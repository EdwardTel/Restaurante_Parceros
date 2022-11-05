package com.example.restauranteparceros.ui.categorias

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restauranteparceros.R
import com.example.restauranteparceros.ui.Comidas

class PlatosAdapter(private val comidasList : MutableList<Comidas>)
    : RecyclerView.Adapter<PlatosViewHolder>() {

    var onItemClick: ((Comidas) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatosViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.platos_list_item, parent, false)
        return PlatosViewHolder(view)
    }

    override fun getItemCount(): Int {
        return comidasList.size
    }

    override fun onBindViewHolder(holder: PlatosViewHolder, position: Int) {
        val comida = comidasList[position]
        holder.nombre.text = comida.nombre
        Glide.with(holder.itemView.context).load(comida.img).into(holder.imagen)


        holder.itemView.setOnClickListener {
            onItemClick?.invoke(comida)
        }
    }
}

class PlatosViewHolder(v: View)
    : RecyclerView.ViewHolder(v){
    val nombre: TextView = itemView.findViewById(R.id.platos_nombre)
    val imagen: ImageView = itemView.findViewById(R.id.platos_imagen)
}
