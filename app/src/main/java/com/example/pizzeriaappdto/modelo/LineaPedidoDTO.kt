package com.example.pizzeriaappdto.modelo

data class LineaPedidoDTO(
    val id:Int,
    val cantidad:Int,
    val pasta:PastaDTO?,
    val bebida:BebidaDTO?,
    val kebab:KebabDTO?,
    val pizza:PizzaDTO?
)