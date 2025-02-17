package com.alvarocervantes.MyIMCv2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class HistoricoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Leer los datos del archivo
        val historico = leerResultados()

        // Configurar el adapter
        recyclerView.adapter = HistoricoAdapter(historico)
    }

    private fun leerResultados(): List<String> {
        val file = File(filesDir, "resultados_imc.txt")
        return if (file.exists()) file.readLines() else emptyList()
    }
}
