package com.example.pizzeriaappdto.modulo

data class PastaDTO(
    val id:Int,
    val nombre:String,
    val precio:Double,
    val listaIngredientesPasta:List<Ingrediente>
)