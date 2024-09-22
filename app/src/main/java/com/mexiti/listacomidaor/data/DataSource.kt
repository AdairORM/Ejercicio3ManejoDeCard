package com.mexiti.listacomidaor.data

import com.mexiti.listacomidaor.R
import com.mexiti.listacomidaor.model.Platillo

class DataSource() {
    fun LoadPlatillos(): List<Platillo> {
        return listOf(
            Platillo(R.string.desayuno, R.drawable.desayuno, "$120", oferta = true), // Desayuno en oferta
            Platillo(R.string.hamburger, R.drawable.hamburger, "$150"),
            Platillo(R.string.pizza, R.drawable.pizza, "$180", oferta = true), // Pizza en oferta
            Platillo(R.string.postre, R.drawable.postre, "$100"),
            Platillo(R.string.pozole, R.drawable.pozole, "$200"),
            Platillo(R.string.tacos, R.drawable.tacos, "$80", oferta = true) // Tacos en oferta
        )
    }
}
