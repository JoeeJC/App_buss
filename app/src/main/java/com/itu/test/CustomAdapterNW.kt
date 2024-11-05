package com.itu.testcd C:\Users\Hnos\test

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Horario(val dia: String, val horas: String)

class CustomAdapterNW(private val items: List<String>, private val context: Context) : RecyclerView.Adapter<CustomAdapterNW.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView =
            itemView.findViewById(R.id.textView) // Asegúrate de que este ID coincida con tu diseño
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]

        // Manejar el clic en el item
        holder.itemView.setOnClickListener {
            showPopup(items[position])
        }
    }

    override fun getItemCount() = items.size

    // Método para mostrar el popup
    private fun showPopup(item: String) {
        val popupView = LayoutInflater.from(context).inflate(R.layout.popup_layout, null)
        val title = popupView.findViewById<TextView>(R.id.popup_title)
        val scheduleTable = popupView.findViewById<TableLayout>(R.id.schedule_table)
        val closeButton = popupView.findViewById<Button>(R.id.close_popup)

        title.text = item

        // Limpia el contenido anterior del TableLayout
        scheduleTable.removeViews(1, scheduleTable.childCount - 1)

        // Cargar horarios de la lista de Horario
        val scheduleDetails = getScheduleDetails(item)
        scheduleDetails.forEach { horario ->
            val row = TableRow(context)

            val dayTextView = TextView(context).apply {
                layoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)
                text = horario.dia
            }

            val hoursTextView = TextView(context).apply {
                layoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)
                text = horario.horas
            }

            row.addView(dayTextView)
            row.addView(hoursTextView)
            scheduleTable.addView(row)
        }

        // Crear y mostrar el PopupWindow
        val popupWindow = PopupWindow(
            popupView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        )
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)

        // Cerrar el popup al hacer clic en el botón
        closeButton.setOnClickListener {
            popupWindow.dismiss()
        }
    }
    // Método para obtener los detalles de horarios según el ítem
    private fun getScheduleDetails(item: String): List<Horario> {
        return when (item) {
            "NuevaGeneracion Ruta Ejemplo 1" -> listOf(
                Horario("Lunes", "09:00, 12:00"),
                Horario("Martes", "10:00, 14:00"),
                // Agrega más días y horarios según sea necesario
            )
            "NuevaGeneracion Ruta Ejemplo 2" -> listOf(
                Horario("Lunes", "10:00, 12:00"),
                Horario("Martes", "11:00, 13:00"),
                // Agrega más días y horarios
            )
            // Agrega más rutas según los elementos de la lista
            else -> emptyList() // Sin horarios disponibles
        }

    }
}