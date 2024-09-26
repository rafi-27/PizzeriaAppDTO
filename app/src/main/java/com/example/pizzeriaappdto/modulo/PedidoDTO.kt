package com.example.pizzeriaappdto.modulo

import java.time.LocalDateTime
import java.util.Date

data class PedidoDTO(
        val id:Int,
        val fecha:LocalDateTime,
        val precio:Double,
        val estado:EstadoPedido,
        val listaLineaPedido:List<LineaPedidoDTO>
)