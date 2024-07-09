package com.humanocomputador.recyclerviewsample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val miAdaptador = ListaContactosAdapter()
        val rv = findViewById<RecyclerView>(R.id.rvContactos)
        rv.apply {
            adapter = miAdaptador
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)

        }


        val miListaContactos : MutableList<ContactoModel> = mutableListOf()

        miListaContactos.add(ContactoModel("Miguel Perez Perez",23, "Jr. Puno 123",1))
        miListaContactos.add(ContactoModel("Juan Mamani Lopez",23, "Jr. Puno 123",1))
        miListaContactos.add(ContactoModel("Maria Quispe Rojas",23, "Jr. Puno 123",1))

        miAdaptador.actualizarLista(miListaContactos)
    }
}