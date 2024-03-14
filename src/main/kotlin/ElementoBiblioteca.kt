package org.pebiblioteca

interface Prestable{
    fun prestar(libro: Libro)

    fun devolver(libro: Libro)
}


abstract class ElementoBiblioteca(val id: Int, var titulo: String, var estado: Estado = Estado.DISPONIBLE) {
}