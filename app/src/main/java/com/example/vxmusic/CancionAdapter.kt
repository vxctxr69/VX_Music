package com.example.vxmusic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent

class CancionAdapter(
    private val canciones: List<Cancion>
) : RecyclerView.Adapter<CancionAdapter.CancionViewHolder>() {

    class CancionViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val textTitulo: TextView =
            itemView.findViewById(R.id.textTituloCancion)

        val textArtista: TextView =
            itemView.findViewById(R.id.textArtistaCancion)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CancionViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.fila_cancion, parent, false)

        return CancionViewHolder(vista)
    }

    override fun onBindViewHolder(
        holder: CancionViewHolder,
        position: Int
    ) {
        val cancion = canciones[position]

        holder.textTitulo.text = cancion.titulo
        holder.textArtista.text = cancion.artista

        holder.itemView.setOnClickListener {
            val contexto = holder.itemView.context

            val intent = Intent(contexto, DetalleCancionActivity::class.java)

            intent.putExtra("titulo", cancion.titulo)
            intent.putExtra("artista", cancion.artista)

            contexto.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return canciones.size
    }
}