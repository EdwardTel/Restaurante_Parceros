package com.example.restauranteparceros.ui.ordenes

class OrganizadorMenu() {

    /*private var comidasSinOrdenar : MutableList<Comidas>

    init {
        comidasSinOrdenar = listaComidas
    }*/

    fun GetEntradas(listaComidas: MutableList<Comidas>): MutableList<Comidas>{

        var listaEntradas : MutableList<Comidas> = mutableListOf()
        for (comida in listaComidas){
            if(comida.tipo=="Entrada"){
                listaEntradas.add(comida)
            }
        }
        return listaEntradas
    }

    fun GetPlatos(listaComidas: MutableList<Comidas>): MutableList<Comidas>{

        var listaPlatos : MutableList<Comidas> = mutableListOf()

        for (comida in listaComidas){
            if(comida.tipo.equals("Plato")){
                listaPlatos.add(comida)
            }
        }
        return listaPlatos
    }

    fun GetPostres(listaComidas: MutableList<Comidas>): MutableList<Comidas>{
        var listaPostres : MutableList<Comidas> = mutableListOf()

        for (comida in listaComidas){
            if(comida.tipo == "Postre"){
                listaPostres.add(comida)
            }
        }
        return listaPostres
    }

    fun GetBebidas(listaComidas: MutableList<Comidas>): MutableList<Comidas>{

        var listaBebidas: MutableList<Comidas> = mutableListOf()
        for (comida in listaComidas){
            if(comida.tipo.equals("Bebida")){
                listaBebidas.add(comida)
            }
        }
        return listaBebidas
    }
}