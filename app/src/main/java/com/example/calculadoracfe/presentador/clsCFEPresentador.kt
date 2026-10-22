package com.example.calculadoracfe.Presentador

import com.example.calculadoracfe.Modelo.clsCFEModelo
import com.example.calculadoracfe.vista.MainActivity

class clsCFEPresentador(private val vista: MainActivity) {
    private val modelo = clsCFEModelo()

    fun CalcularKWConsumidos(txtLectAct: String, txtLectAnt: String) {
        val lectAct = txtLectAct.toDoubleOrNull() ?: 0.0
        val lectAnt = txtLectAnt.toDoubleOrNull() ?: 0.0

        val kwConsumidos = modelo.CalcularKwConsumidos(lectAct, lectAnt)
        vista.mostrarKwConsumidos(kwConsumidos.toString())
    }

    fun CalcularRecibo(KwConsumidos: Double, txtCostoKw: String) {
        val costoKw = txtCostoKw.toDoubleOrNull() ?: 0.0
        val recibo = modelo.CalcularRecibo(costoKw, KwConsumidos)

        vista.mostrarPagodelRecibo(recibo.toString())
    }
}