package com.example.restauranteparceros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.restauranteparceros.databinding.ActivityDetailBinding
import com.example.restauranteparceros.ui.Comidas
import com.example.restauranteparceros.ui.Pedido
import com.example.restauranteparceros.ui.acerca.HomeViewModel
import com.example.restauranteparceros.ui.cuenta.CuentaViewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val cuentaViewModel = ViewModelProvider(this).get(CuentaViewModel::class.java)

        val comida = intent.getParcelableExtra<Comidas>("comida")
        if (comida != null){

            binding.detailTvDescripcion.text = comida.descripcion
            binding.detalTvPrecio.text = comida.precio.toString()
            Glide.with(this).load(comida.img).into(binding.detailImagen)
        }

        binding.btnRegresar.setOnClickListener{
            this.finish()
        }*/

        /*binding.btnAgregar.setOnClickListener{
            var nombre = comida?.nombre
            var cantidad = binding.etCantidad.text.toString().toInt()
            var precio = comida?.precio

            val pedido = Pedido(nombre, cantidad, precio)
            cuentaViewModel.listaPedidos.add(pedido)
            cuentaViewModel.readListaPedidos()*/

            /*for(a in cuentaViewModel.listaPedidos){
                Log.d("Detail", a.nombre!!)
                Log.d("Detail", a.cantidad.toString())
                Log.d("Detail", a.precio.toString())
            }*/
        }

}