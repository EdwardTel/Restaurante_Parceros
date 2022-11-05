package com.example.restauranteparceros.ui.acerca

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restauranteparceros.ui.Comidas
import com.example.restauranteparceros.ui.OrganizadorMenu

class HomeViewModel : ViewModel() {

    val organizador = OrganizadorMenu()
    var comidasEnBD : MutableList<Comidas> = mutableListOf()

    private var _entradas = MutableLiveData<MutableList<Comidas>>()
    val entradas: LiveData<MutableList<Comidas>> = _entradas

    private var _platos = MutableLiveData<MutableList<Comidas>>()
    val platos: LiveData<MutableList<Comidas>> = _platos

    private var _postres = MutableLiveData<MutableList<Comidas>>()
    val postres: LiveData<MutableList<Comidas>> = _postres

    private var _bebidas = MutableLiveData<MutableList<Comidas>>()
    val bebidas: LiveData<MutableList<Comidas>> = _bebidas

    fun setEntradas(){
        _entradas.apply {
            value = organizador.GetEntradas(comidasEnBD)
        }
    }

    fun setPlatos(){
        _platos.apply {
            value = organizador.GetPlatos(comidasEnBD)
        }
    }

    fun setPostres(){
        _postres.apply {
            value = organizador.GetPostres(comidasEnBD)
        }
    }

    fun setBebidas(){
        _bebidas.apply {
            value = organizador.GetBebidas(comidasEnBD)
        }
    }
}