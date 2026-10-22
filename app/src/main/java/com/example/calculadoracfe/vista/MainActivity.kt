package com.example.calculadoracfe.vista

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoracfe.Presentador.clsCFEPresentador
import com.example.calculadoracfe.R

class MainActivity : AppCompatActivity() {

    private lateinit var txtLectAnterior: EditText
    private lateinit var txtLectActual: EditText
    private lateinit var txtCostoKw: EditText
    private lateinit var btnCalcularKw: Button
    private lateinit var txtConsumidosKw: TextView
    private lateinit var btnCalcularRecibo: Button
    private lateinit var txtPagoRecibo: TextView
    private lateinit var btnPasarDatos: Button

    private lateinit var presentador: clsCFEPresentador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtLectAnterior = findViewById(R.id.txtLectAnterior)
        txtLectActual = findViewById(R.id.txtLectActual)
        txtCostoKw = findViewById(R.id.txtCostoKw)
        btnCalcularKw = findViewById(R.id.btnCalcularKw)
        txtConsumidosKw = findViewById(R.id.txtKwConsumidos)
        btnCalcularRecibo = findViewById(R.id.btnCalcularRecibo)
        txtPagoRecibo = findViewById(R.id.txtRecibo)
        btnPasarDatos = findViewById(R.id.btnPasarDatos)

        presentador = clsCFEPresentador(this)

        btnCalcularKw.setOnClickListener (this::ejecutarCalcularKw)

        btnCalcularRecibo.setOnClickListener(this::ejecutarCalcularRecibo)
        btnPasarDatos.setOnClickListener(this::ejecutarPasarDatos)
    }
    fun ejecutarCalcularKw(v: View)
    {
        presentador.CalcularKWConsumidos(txtLectAnterior.text.toString(),txtLectActual.text.toString())
    }
    fun ejecutarCalcularRecibo(v: View)
    {
        presentador.CalcularRecibo(txtConsumidosKw.text.toString().toDouble(),txtCostoKw.text.toString() )
    }


    fun mostrarKwConsumidos(kwconsumidos: String) {
        txtConsumidosKw.text = kwconsumidos
    }
    fun mostrarPagodelRecibo(pagoRecibo: String) {
        txtPagoRecibo.text = pagoRecibo
    }
    fun ejecutarPasarDatos(v: View)
    {
        val vista2 = Intent(this, VistaResultados::class.java).apply{
            putExtra("EXTRA_KWCONSUMIDOS", txtConsumidosKw.text)
            putExtra("EXTRA_RECIBO", txtPagoRecibo.text)
        }
        this.startActivity(vista2)
    }

}