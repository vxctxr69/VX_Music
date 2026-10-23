package com.example.vxmusic

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titulo = findViewById<TextView>(R.id.titulo)

        val etTitulo = findViewById<EditText>(R.id.editNombre)
        val etArtista = findViewById<EditText>(R.id.editEdad)
        val btnAñadir = findViewById<Button>(R.id.btnAñadir)
        val btnBiblioteca = findViewById<Button>(R.id.btnBiblioteca)

        // Acción del botón Añadir canción
        btnAñadir.setOnClickListener {
            val nombreCancion = etTitulo.text.toString().trim()
            val artista = etArtista.text.toString().trim()

            if (nombreCancion.isEmpty() || artista.isEmpty()) {
                Toast.makeText(
                    this,
                    "Escribe el nombre de la canción y el artista",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val cancion = Cancion(nombreCancion, artista)

                Biblioteca.canciones.add(cancion)

                Toast.makeText(
                    this,
                    "Canción añadida: $nombreCancion",
                    Toast.LENGTH_SHORT
                ).show()

                etTitulo.text.clear()
                etArtista.text.clear()
            }
        }

        // Acción provisional del botón Biblioteca
        btnBiblioteca.setOnClickListener {
            val intent = Intent(this, BibliotecaActivity::class.java)
            startActivity(intent)
        }
    }
}