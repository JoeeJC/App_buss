package com.itu.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class dcFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dc, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewDc)

        // Configuración del RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CustomAdapterDC(getDataDC()) // Cargar datos con el adaptador CustomAdapterDC

        return view
    }

    private fun getDataDC(): List<String> {
        // Aquí se definen los datos específicos del fragmento DC
        return listOf("Diccetours Ruta Ejemplo 1",
            "Diccetours Ruta Ejemplo 2",
            "Diccetours Ruta Ejemplo 3",
            "Diccetours Ruta Ejemplo 4",
            "Diccetours Ruta Ejemplo 5",
            "Diccetours Ruta Ejemplo 6",
            "Diccetours Ruta Ejemplo 7",
            "Diccetours Ruta Ejemplo 8",
            "Diccetours Ruta Ejemplo 9",
            "Diccetours Ruta Ejemplo 10",
            "Diccetours Ruta Ejemplo 11"
        )
    }
}