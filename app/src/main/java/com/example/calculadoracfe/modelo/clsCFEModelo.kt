package com.example.calculadoracfe.Modelo

class clsCFEModelo {

    fun CalcularKwConsumidos(lectAct: Double, lectAnt: Double): Double {
        return lectAct - lectAnt
    }

    fun CalcularRecibo(costoKw: Double, kwConsumidos: Double): Double {
        return costoKw * kwConsumidos
    }
}