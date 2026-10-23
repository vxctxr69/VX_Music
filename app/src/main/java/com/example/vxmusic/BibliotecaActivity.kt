package com.example.vxmusic

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BibliotecaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biblioteca)

        val recyclerCanciones =
            findViewById<RecyclerView>(R.id.recyclerCanciones)

        val btnVolver = findViewById<Button>(R.id.btnVolver)

        btnVolver.setOnClickListener {
            finish()
        }

        recyclerCanciones.layoutManager =
            LinearLayoutManager(this)

        recyclerCanciones.adapter =
            CancionAdapter(Biblioteca.canciones)
    }
}