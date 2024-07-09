package com.humanocomputador.recyclerviewsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListaContactosAdapter:RecyclerView.Adapter<ListaContactosAdapter.ViewHolder>() {

    var lstContactos:List<ContactoModel> = emptyList()

    fun actualizarLista(lst:List<ContactoModel>){
        lstContactos = lst
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) :RecyclerView.ViewHolder(view) {
        val tvNombre = view.findViewById<TextView>(R.id.tvNombre)
        val tvEdad = view.findViewById<TextView>(R.id.tvEdad)
        val tvGenero = view.findViewById<TextView>(R.id.tvGenero)
        val ivLogo = view.findViewById<ImageView>(R.id.ivLogo)

        fun setValues(model: ContactoModel){
            tvNombre.setText(model.nombre)
            tvEdad.setText(model.edad.toString() + " años")
            if(model.genero == 1)
                tvGenero.setText("Masculino")
            else
                tvGenero.setText("Femenino")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contactos,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        //el tamaño de mi lista
        return lstContactos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setValues(lstContactos[position])
        holder.ivLogo.setOnClickListener{

        }
    }
}