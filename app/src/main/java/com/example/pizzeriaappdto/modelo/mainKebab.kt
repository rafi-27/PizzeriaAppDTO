package com.example.pizzeriaappdto.modelo
import kotlin.collections.listOf

fun main() {
    var listaKebabs: List<KebabDTO> = listOf(
        KebabDTO(listOf(Ingrediente(1,"PrimerKebab", listOf())),SIZE.PEQUEÑA,TIPO_CARNE.POLLO,10.0),
        KebabDTO(listOf(Ingrediente(2,"CuartoKebab", listOf())),SIZE.GRANDE,TIPO_CARNE.MIXTO,12.0),
        KebabDTO(listOf(Ingrediente(3,"TercerKebab", listOf())),SIZE.MEDIANA,TIPO_CARNE.TERNERA,18.0))





    //Con lambda:
    //println(listaKebabs.forEach(elemento:KebabDTO ))

    //println(listaKebabs.map { it.precio }.forEach(k:Ke))


    //println(listaKebabs.filter { it.tipoCarne==TIPO_CARNE.POLLO }.forEach())

    listaKebabs.forEach{println(it.toString())}

    listaKebabs.map { it.precio*2 }.forEach{ println() }
    //listaKebabs.forEach{it}







//    //Sin lambda:
//    for (kebab in listaKebabs){
//        println(kebab.toString()+"\\n")
//    }
//    println()
//
//    for (kebab in listaKebabs){
//        println(kebab.precio*2)
//    }
//    println()
//
//    for (keba in listaKebabs){
//        if (keba.tipoCarne==TIPO_CARNE.POLLO){
//            println(keba)
//        }
//    }

}
