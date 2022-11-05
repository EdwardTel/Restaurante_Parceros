package com.example.restauranteparceros.ui

class OrganizadorMenu{

    fun GetEntradas(listaComidas: MutableList<Comidas>): MutableList<Comidas>{

        val listaEntradas : MutableList<Comidas> = mutableListOf()

        for (comida in listaComidas){
            if(comida.tipo.equals("Entrada")){
                listaEntradas.add(comida)
            }
        }
        return listaEntradas
    }

    fun GetPlatos(listaComidas: MutableList<Comidas>): MutableList<Comidas>{

        val listaPlatos : MutableList<Comidas> = mutableListOf()

        for (comida in listaComidas){
            if(comida.tipo.equals("Plato")){
                listaPlatos.add(comida)
            }
        }
        return listaPlatos
    }

    fun GetPostres(listaComidas: MutableList<Comidas>): MutableList<Comidas>{
        val listaPostres : MutableList<Comidas> = mutableListOf()

        for (comida in listaComidas){
            if(comida.tipo == "Postre"){
                listaPostres.add(comida)
            }
        }
        return listaPostres
    }

    fun GetBebidas(listaComidas: MutableList<Comidas>): MutableList<Comidas>{

        val listaBebidas: MutableList<Comidas> = mutableListOf()
        for (comida in listaComidas){
            if(comida.tipo.equals("Bebida")){
                listaBebidas.add(comida)
            }
        }
        return listaBebidas
    }
}