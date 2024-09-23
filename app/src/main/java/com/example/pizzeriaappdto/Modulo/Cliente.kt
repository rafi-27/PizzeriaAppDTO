package com.example.pizzeriaappdto.Modulo

data class Cliente(
    val id:Int,
    val dni:String,
    val nombre:String,
    val direccion:String,
    val telefono:String,
    val email:String,
    val password:String
)