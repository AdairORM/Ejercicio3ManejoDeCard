package com.mexiti.listacomidaor.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Platillo(
    @StringRes val stringResourceId: Int,
    @DrawableRes val drawableResourceId: Int,
    val precio: String,         // Añadir campo para el precio
    val oferta: Boolean = false // Añadir campo para indicar si hay oferta (por defecto es false)
)
