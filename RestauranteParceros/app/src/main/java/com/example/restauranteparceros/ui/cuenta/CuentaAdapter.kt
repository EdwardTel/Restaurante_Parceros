package com.example.restauranteparceros.ui.cuenta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restauranteparceros.R
import com.example.restauranteparceros.ui.Pedido

class CuentaAdapter(private val pedidoList : MutableList<Pedido>)
    : RecyclerView.Adapter<CuentaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuentaViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cuenta_list_item, parent, false)
        return CuentaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pedidoList.size
    }

    override fun onBindViewHolder(holder: CuentaViewHolder, position: Int) {
        val pedido = pedidoList[position]
        holder.nombre.text = pedido.nombre
        holder.cantidad.text = pedido.cantidad.toString()
        holder.precio.text = pedido.precio.toString()
    }
}

class CuentaViewHolder(v: View)
    : RecyclerView.ViewHolder(v){
    val nombre: TextView = v.findViewById(R.id.cuenta_nombre)
    val cantidad: TextView = v.findViewById(R.id.cuenta_cantidad)
    val precio: TextView = v.findViewById(R.id.cuenta_precio)
}
