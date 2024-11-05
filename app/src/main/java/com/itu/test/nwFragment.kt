package com.itu.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class nwFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Que xml se mostrara en este fragmento
        val view = inflater.inflate(R.layout.fragment_nw, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewNw)

        // Configuración del RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CustomAdapterNW(getDataNW(), requireContext()) // Cargar datos con el adaptador CustomAdapterNW

        return view
    }

    private fun getDataNW(): List<String> {
        // Aquí se muestras los datos que seran visibles del RecyclerView
        return listOf("NuevaGeneracion Ruta Ejemplo 1",
            "NuevaGeneracion Ruta Ejemplo 2",
            "NuevaGeneracion Ruta Ejemplo 3",
            "NuevaGeneracion Ruta Ejemplo 4",
            "NuevaGeneracion Ruta Ejemplo 5",
            "NuevaGeneracion Ruta Ejemplo 6",
            "NuevaGeneracion Ruta Ejemplo 7",
            "NuevaGeneracion Ruta Ejemplo 8",
            "NuevaGeneracion Ruta Ejemplo 9",
            "NuevaGeneracion Ruta Ejemplo 10",
            "NuevaGeneracion Ruta Ejemplo 11",
            "NuevaGeneracion Ruta Ejemplo 12",

        )
    }
}