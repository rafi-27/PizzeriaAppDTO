package com.example.pizzeriaappdto.modelo

data class Ingrediente(
    val id:Int,
    val nombre:String,
    val alergenos:List<String>
)