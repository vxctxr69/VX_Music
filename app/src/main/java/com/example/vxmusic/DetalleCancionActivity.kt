package com.example.vxmusic

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class DetalleCancionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_cancion)

        val titulo = intent.getStringExtra("titulo")
        val artista = intent.getStringExtra("artista")

        val textTitulo = findViewById<TextView>(R.id.textDetalleTitulo)
        val textArtista = findViewById<TextView>(R.id.textDetalleArtista)

        textTitulo.text = titulo ?: "Sin título"
        textArtista.text = artista ?: "Artista desconocido"

        val btnVolver = findViewById<Button>(R.id.btnVolverDetalle)

        btnVolver.setOnClickListener {
            finish()
        }
    }
}