package com.example.pizzeriaappdto.modulo

import java.util.Date

data class PedidoDTO(
        val id:Int,
        val fecha:Date,
        val precio:Double,
        val estado:EstadoPedido,
        val listaLineaPedido:List<LineaPedidoDTO>
)