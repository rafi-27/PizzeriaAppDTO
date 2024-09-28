package com.example.pizzeriaappdto

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.pizzeriaappdto.modulo.ClienteDTO
import com.example.pizzeriaappdto.modulo.EstadoPedido
import com.example.pizzeriaappdto.modulo.Ingrediente
import com.example.pizzeriaappdto.modulo.LineaPedidoDTO
import com.example.pizzeriaappdto.modulo.PedidoDTO
import com.example.pizzeriaappdto.modulo.PizzaDTO
import com.example.pizzeriaappdto.modulo.SIZE
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
fun main() {

    //Probamos Instanciar objetos para comprobar que almacenan los datos:
    val listaPedidos= mutableListOf<PedidoDTO>()

    val primerPedido=PedidoDTO(2, LocalDateTime.now(),45.0,EstadoPedido.CANCELADO, listOf(LineaPedidoDTO(1,5,null,null,PizzaDTO(1,"Gambas",9.0,SIZE.GRANDE, listOf(Ingrediente(1,"Queso", listOf("Hola")))))))
    val segundoPedido=PedidoDTO(34, LocalDateTime.now(),45.0,EstadoPedido.CANCELADO, listOf(LineaPedidoDTO(1,5,null,null,PizzaDTO(1,"Gambas",9.0,SIZE.GRANDE, listOf(Ingrediente(1,"Queso", listOf("Hola")))))))
    val tercerPedido=PedidoDTO(67, LocalDateTime.now(),45.0,EstadoPedido.CANCELADO, listOf(LineaPedidoDTO(1,5,null,null,PizzaDTO(1,"Gambas",9.0,SIZE.GRANDE, listOf(Ingrediente(1,"Queso", listOf("Hola")))))))


    val clienteUno = ClienteDTO(7,"12345678I","Rafe","calle calle","123456789","correo@gmail.com","1234",listaPedidos)

    listaPedidos.addAll(listOf(primerPedido,segundoPedido,tercerPedido))


    println(clienteUno)






    //Lista con pizzas ingredientes y alergenos
    val listaPizzas: List<PizzaDTO> = mutableListOf(
        PizzaDTO(
            1,
            "Pizza Atuzn",
            9.0,
            SIZE.GRANDE,
            listOf(Ingrediente(1, "Atun", listOf("Gluten")),
                Ingrediente(1, "Kebab", listOf("Cancer", "Gluten")))
        ),
        PizzaDTO(
            2,
            "Pizza Marisocos",
            5.0,
            SIZE.PEQUEÑA,
            listOf(
                Ingrediente(2, "A", listOf("Cancer")),
                Ingrediente(3, "Salmon", listOf("Calcio")),
                Ingrediente(1, "Kebab", listOf("Cancer", "Gluten"))
            )
        ),
        PizzaDTO(
            7,
            "Pizza Kebab",
            10.0,
            SIZE.MEDIANA,
            listOf(
                Ingrediente(5, "kebab", listOf("Gluten")),
                Ingrediente(5, "salsaPicante", listOf("AlergenoUno"))
            )
        ),
        PizzaDTO(
            3,
            "Pizza Atun",
            15.0,
            SIZE.GRANDE,
            listOf(Ingrediente(3, "Atun", listOf("Pimie", "Arro")))
        ),
        PizzaDTO(
            4,
            "Pizza Atuzn",
            6.0,
            SIZE.GRANDE,
            listOf(Ingrediente(1, "Gamba", listOf("Glutoma")))
        )
    )

    //Cliente no puede comer ingreditnes con estos alergenos:
    val listaAlergenos: List<String> =
        mutableListOf("Gluten", "Glutoma", "Cancer", "AlergenoUno", "AlergenoDos")

    //Creamos una lista de ingredientes:
    val listaingr: List<Ingrediente> = listOf(
        Ingrediente(1, "Kebab", listOf("Cancer", "Gluten")),
        Ingrediente(2, "Queso", listOf("Gluten", "AlergenoUno")),
        Ingrediente(3, "Atun", listOf("Pimie", "Arro")),
        Ingrediente(4, "Salmon", listOf("Sal", "Glucosa"))
    )

    val guines:String="-----------------------------------------------------------------------------------------"

    //Creamos el controlador:
    var control: Controlador = Controlador()

    //Probamos flitrado por precios:
    println("Filtramos por precio: ")
    println(control.filtradoDePizzas(listaPizzas, 10, 12))
    println(guines)


    //Probamos filtrado por alergenos:
    println("Filtramos ingredientes que podemos consumir: ")
    println(control.filtradoDeIngredientes(listaAlergenos, listaingr))
    println(guines)


    //Probamos filtrado por alergenos:
    println("Filtramos Precios ASC: ")
    println(control.ordenarPizzasPrecio(true, listaPizzas))
    println("Filtramos Precios DESC: ")
    println(control.ordenarPizzasPrecio(false, listaPizzas))
    println(guines)

    //Probamos contar pizzas
    println("Porbamos haber cuantas pizzas tienen un ingrediente que le pasas: ")
    println(control.contarPizzasPorIngrediente(listaingr.get(1), listaPizzas))
    println(control.contarPizzasPorIngrediente(listaingr.get(3), listaPizzas))
    println(control.contarPizzasPorIngrediente(listaingr.get(2), listaPizzas))

}

class Controlador {
    //Primer metodo:
    fun filtradoDePizzas(listaPizza: List<PizzaDTO>, min: Int = 7, max: Int = 10): List<PizzaDTO> {
        return listaPizza.filter { it.precio >= min && it.precio < max }//implicita
        //return listaPizza.filter { pizza:PizzaDTO -> pizza.precio in min .. max }//explicita
    }

    //Segundo metodo:
    /**
     * filtrarIngredientes debe filtrar cualquier ingrediente que contenga algún alérgeno,
     * es decir, no puede contener ninguno. Sin embargo, tu función (not all), permite que con que no
     * contenga todos los alérgenos, entra en el filtrado. La solución correcta es la del none, que la tienes comentada abajo.
     */
    fun filtradoDeIngredientes(
        listaAlergenos: List<String>,
        listaIngredientes: List<Ingrediente>
    ): List<Ingrediente> {
        return listaIngredientes.filter { it.alergenos.none() { it in listaAlergenos } }
    }

    //Otras formas de hacerlo la que uso en mi punto de vista es la mas sencilla.
    //return listaIngredientes.filter{it.alergenos.all { it !in listaAlergenos }}
    //return listaIngredientes.filter {it.alergenos.none() {it in listaAlergenos} }

    //Tercer metodo:
    fun ordenarPizzasPrecio(orden:Boolean, listaPizzillas: List<PizzaDTO>): List<PizzaDTO> {
        return if (orden) listaPizzillas.sortedBy { it.precio } else listaPizzillas.sortedByDescending { it.precio }
        //return listaPizzillas.sortedBy {orden.equals("ASC") }
    }

    //Cuarto metodo:Contador de pizzas. Contar pizzas que tengan un ingrediente concreto //pasado por parámetro.
    fun contarPizzasPorIngrediente(ingre: Ingrediente, listaPizzasAFiltrar: List<PizzaDTO>): Int {
        return listaPizzasAFiltrar.filter { it.listaIngredientesPizza.any { it.nombre.equals(ingre.nombre, ignoreCase = true) } }
            .count()
    }
    /**
     * fun contarPizzasPorIngrediente(ingre: String, listaPizzasAFiltrar: List<PizzaDTO>): Int {
     *         return listaPizzasAFiltrar.filter { it.listaIngredientesPizza.any { it.nombre.equals(ingre) } }
     *             .count()
     *     }
     */
    // listaPizzasAFiltrar.filter {it.listaIngredientesPizza.all { it.nombre.equals(ingre) }}.count()
    //return listaPizzasAFiltrar.filter {it.listaIngredientesPizza.all { it.nombre.equals(ingre) }}.count()
}