package com.example.laboratorio2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.laboratorio02.R

class MainLab : AppCompatActivity() {

    private lateinit var editNombre: EditText
    private lateinit var editEdad: EditText
    private lateinit var editDepartamento: EditText
    private lateinit var btnAgregar: Button
    private lateinit var listViewNombres: ListView
    private lateinit var txtDetalles: TextView

    private val listaNombres = ArrayList<String>()
    private val listaEdades = ArrayList<String>()
    private val listaDepartamentos = ArrayList<String>()

    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNombre = findViewById(R.id.editNombre)
        editEdad = findViewById(R.id.editEdad)
        editDepartamento = findViewById(R.id.editDepartamento)
        btnAgregar = findViewById(R.id.btnAgregar)
        listViewNombres = findViewById(R.id.listViewNombres)
        txtDetalles = findViewById(R.id.txtDetalles)


        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNombres)
        listViewNombres.adapter = adapter

        btnAgregar.setOnClickListener {
            val nombre = editNombre.text.toString().trim()
            val edad = editEdad.text.toString().trim()
            val departamento = editDepartamento.text.toString().trim()

            if (nombre.isNotEmpty() && edad.isNotEmpty() && departamento.isNotEmpty()) {

                listaNombres.add(nombre)
                listaEdades.add(edad)
                listaDepartamentos.add(departamento)

                adapter.notifyDataSetChanged()

                editNombre.text.clear()
                editEdad.text.clear()
                editDepartamento.text.clear()

                txtDetalles.text = "Selecciona un nombre de la lista para ver los detalles"

            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        listViewNombres.setOnItemClickListener { _, _, position, _ ->
            val detalles = "Edad: ${listaEdades[position]}\nDepartamento: ${listaDepartamentos[position]}"
            txtDetalles.text = detalles
        }
    }
}