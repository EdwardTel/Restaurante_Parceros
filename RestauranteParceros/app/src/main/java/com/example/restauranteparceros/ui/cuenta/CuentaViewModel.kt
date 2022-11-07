package com.example.restauranteparceros.ui.cuenta

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restauranteparceros.ui.Comidas
import com.example.restauranteparceros.ui.Pedido

class CuentaViewModel : ViewModel() {
    var listaPedidos: MutableList<Pedido> = mutableListOf()
}