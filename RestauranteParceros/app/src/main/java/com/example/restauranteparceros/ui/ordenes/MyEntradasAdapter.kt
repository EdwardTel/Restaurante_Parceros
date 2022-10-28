package com.example.restauranteparceros.ui.ordenes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restauranteparceros.R

class MyEntradasAdapter(private val comidasList : MutableList<Comidas>): RecyclerView.Adapter<MyEntradasAdapter.MyEntradasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyEntradasViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.entradas_list_item,parent,false)

        return MyEntradasViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyEntradasViewHolder, position: Int) {

        val comida: Comidas = comidasList[position]

        holder.nombre.text = comida.nombre
        holder.descripcion.text = comida.descripcion
        holder.precio.text = comida.precio.toString()
    }

    override fun getItemCount(): Int { return comidasList.size }

    inner class MyEntradasViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val nombre = itemView.findViewById<TextView>(R.id.entradas_nombre)
        val descripcion = itemView.findViewById<TextView>(R.id.entradas_descripcion)
        val precio = itemView.findViewById<TextView>(R.id.entradas_precio)
    }

}