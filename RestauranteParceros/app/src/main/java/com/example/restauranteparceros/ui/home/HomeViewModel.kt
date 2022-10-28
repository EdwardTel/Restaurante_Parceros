package com.example.restauranteparceros.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restauranteparceros.ui.ordenes.Comidas
import com.example.restauranteparceros.ui.ordenes.OrganizadorMenu

class HomeViewModel : ViewModel() {

    val organizador = OrganizadorMenu()
    var listaEntradas : MutableList<Comidas> = mutableListOf()
    var comidasEnBD : MutableList<Comidas> = mutableListOf()

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    private var _entradas = MutableLiveData<MutableList<Comidas>>()

    fun setEntradas(){
        _entradas.apply {
            value = organizador.GetEntradas(comidasEnBD)
        }
    }

    val text: LiveData<String> = _text
    val entradas: LiveData<MutableList<Comidas>> = _entradas


    /*private var entradas: MutableLiveData<MutableList<Comidas>> by lazy {
        MutableLiveData<MutableList<Comidas>>().also {
            entradas.value = organizador.GetEntradas()
        }
    }*/
    //private var entradas: MutableLiveData<MutableList<Comidas>> = MutableLiveData()
    private var platos: MutableLiveData<MutableList<Comidas>> = MutableLiveData<MutableList<Comidas>>()
    private var postres: MutableLiveData<MutableList<Comidas>> = MutableLiveData<MutableList<Comidas>>()
    private var bebidas: MutableLiveData<MutableList<Comidas>> = MutableLiveData<MutableList<Comidas>>()

    /*fun readEntradas(): LiveData<MutableList<Comidas>> {
        return entradas
    }*/
    //val readEntradas : LiveData<MutableList<Comidas>> get() = entradas
    val readPlatos : LiveData<MutableList<Comidas>> get() = platos
    val readPostres : LiveData<MutableList<Comidas>> get() = postres
    val readBebidas : LiveData<MutableList<Comidas>> get() = bebidas


    fun distribuirComidas() {
        listaEntradas = OrganizadorMenu().GetEntradas(comidasEnBD)
    }

}