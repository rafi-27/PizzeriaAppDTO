package com.example.pizzeriaappdto.modulo

data class Ingrediente(
    val id:Int,
    val nombre:String,
    val alergenos:List<String>
)