package com.example.calculadoracfe.vista

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoracfe.R

class VistaResultados : AppCompatActivity() {
    private lateinit var txtConsumidosKw: TextView
    private lateinit var txtPagoRecibo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_vista_resultados)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtConsumidosKw=findViewById(R.id.txtKwConsumidos)
        txtPagoRecibo=findViewById(R.id.txtRecibo)
        // 1. Recuperar los datos enviados de la vista 1
        val kw = intent.getStringExtra("EXTRA_KWCONSUMIDOS")
        val total = intent.getStringExtra("EXTRA_RECIBO")
        // 2. Mostrar los resultados en la interfaz vista 2
        txtConsumidosKw.text= "KW Consumidos: $kw"
        txtPagoRecibo.text= "Total a Pagar: $$total"

    }
}