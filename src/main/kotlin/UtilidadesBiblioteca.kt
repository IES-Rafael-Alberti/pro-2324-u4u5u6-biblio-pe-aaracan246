package org.pebiblioteca


import jdk.incubator.vector.VectorOperators.ABS
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.abs
open class UtilidadesBiblioteca{
/**
 * @return Int
 *
 * Mediante un companion object creamos una función que genere un ID randomizado (número de 1 a 120).
 *
 * */
    companion object{
        fun generateID(): Int{
            val listaIds = mutableListOf<Int>()
            val randomId = (1..120).random()
//            ConsoleSystem.printer("$randomId")
            if (!listaIds.contains(randomId)){
                listaIds.add(randomId)}
            return randomId
        }
    }


}