package com.example.pizzeriaappdto.modulo

data class LineaPedidoDTO(
    val id:Int,
    val cantidad:Int,
    val pasta:PastaDTO?,
    val bebida:BebidaDTO?,
    val pizza:PizzaDTO?
)