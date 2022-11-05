package com.example.restauranteparceros.ui.ordenes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restauranteparceros.ui.Comidas

class OrdenesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Ordenes Fragment"
    }
    val text: LiveData<String> = _text

    val pedidosEntradas: MutableList<Comidas> = mutableListOf()
}