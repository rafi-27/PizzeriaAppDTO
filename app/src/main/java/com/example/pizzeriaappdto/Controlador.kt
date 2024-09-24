package com.example.pizzeriaappdto

import com.example.pizzeriaappdto.modulo.Ingrediente
import com.example.pizzeriaappdto.modulo.PizzaDTO
import com.example.pizzeriaappdto.modulo.SIZE

fun main(){
    //Lista con pizzas ingredientes y alergenos
    val listaPizzas:List<PizzaDTO> = mutableListOf(
        PizzaDTO(1,"Pizza Atuzn",9.0,SIZE.GRANDE, listOf(Ingrediente(1,"Atun", listOf("Gluten")))),
        PizzaDTO(2,"Pizza Marisocos",5.0,SIZE.PEQUEÑA, listOf(Ingrediente(2,"Gamba", listOf("Cancer")),Ingrediente(3,"Salmon", listOf("Calcio")))),
        PizzaDTO(7,"Pizza Kebab",10.0,SIZE.MEDIANA, listOf(Ingrediente(5,"kebab", listOf("Gluten")),Ingrediente(5,"salsaPicante", listOf("AlergenoUno")))),
        PizzaDTO(3,"Pizza Atun",15.0,SIZE.GRANDE, listOf(Ingrediente(1,"AtunTomate", listOf("Gludame")))),
        PizzaDTO(4,"Pizza Atuzn",6.0,SIZE.GRANDE, listOf(Ingrediente(1,"Atun", listOf("Glutoma"))))
        )

    //Cliente no puede comer ingreditnes con estos alergenos:
    val listaAlergenos:List<String> = mutableListOf("Gluten","Glutoma","Cancer","AlergenoUno","AlergenoDos")

    //Creamos una lista de ingredientes:
    val listaingr:List<Ingrediente> = listOf(
        Ingrediente(1,"Kebab", listOf("Cancer","Gluten")),
        Ingrediente(2,"Queso", listOf("Gluten","AlergenoUno")),
        Ingrediente(3,"Atun", listOf("Pimie","Arro")),
        Ingrediente(4,"Salmon", listOf("Sal","Glucosa"))
    )

    //Creamos el controlador:
    var control:Controlador = Controlador()

    //Probamos flitrado por precios:
    println("Filtramos por precio: ")
    println(control.filtradoDePizzas(listaPizzas))
    println("-----------------------------------------------------------------------------------------")


    //Probamos filtrado por alergenos:
    println("Filtramos ingredientes que podemos consumir: ")
    println(control.filtradoDeIngredientes(listaAlergenos,listaingr))
    println("-----------------------------------------------------------------------------------------")


    //Probamos filtrado por alergenos:
    println("Filtramos Precios ASC: ")
    println(control.ordenarPizzasPrecio("ASC",listaPizzas))
    println("Filtramos Precios DESC: ")
    println(control.ordenarPizzasPrecio("DESC",listaPizzas))
    println("-----------------------------------------------------------------------------------------")



}

class Controlador{
    //Primer metodo:
    fun filtradoDePizzas(listaPizza:List<PizzaDTO>,min:Int=7,max:Int=10):List<PizzaDTO>{
        return listaPizza.filter { it.precio >= min && it.precio<max }//implicita
        //return listaPizza.filter { pizza:PizzaDTO -> pizza.precio in min .. max }//explicita
    }

    //Segundo metodo:
    fun filtradoDeIngredientes(listaAlergenos:List<String>,listaIngredientes:List<Ingrediente>):List<Ingrediente>{
        return listaIngredientes.filter{!it.alergenos.all { it in listaAlergenos }}
    }
    //Otras formas de hacerlo la que uso en mi punto de vista es la mas sencilla.
    //return listaIngredientes.filter{it.alergenos.all { it !in listaAlergenos }}
    //return listaIngredientes.filter {it.alergenos.none() {it in listaAlergenos} }

    //Tercer metodo:
    fun ordenarPizzasPrecio(orden:String,listaPizzillas:List<PizzaDTO>):List<PizzaDTO>{
        if (orden.equals("ASC")) return listaPizzillas.sortedBy { it.precio } else return listaPizzillas.sortedByDescending { it.precio }
        //return listaPizzillas.sortedBy {orden.equals("ASC") }
    }

    //Cuarto metodo:





}




