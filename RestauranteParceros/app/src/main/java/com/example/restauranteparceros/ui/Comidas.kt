package com.example.restauranteparceros.ui

import android.os.Parcel
import android.os.Parcelable

data class Comidas(var tipo: String?, var nombre: String?, var descripcion: String?, var img: String?, var precio: Double?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tipo)
        parcel.writeString(nombre)
        parcel.writeString(descripcion)
        parcel.writeString(img)
        parcel.writeValue(precio)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Comidas> {
        override fun createFromParcel(parcel: Parcel): Comidas {
            return Comidas(parcel)
        }

        override fun newArray(size: Int): Array<Comidas?> {
            return arrayOfNulls(size)
        }
    }
}