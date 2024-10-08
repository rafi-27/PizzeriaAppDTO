package com.example.pizzeriaappdto.modelo

data class PastaDTO(
    val id:Int,
    val nombre:String,
    val precio:Double,
    val listaIngredientesPasta:List<Ingrediente>
)