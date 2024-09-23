package com.example.pizzeriaappdto.Modulo

import java.util.Date

data class Pedido(
        val id:Int,
        val fecha:Date,
        val precio:Double,
        val estado:EstadoPedido
)