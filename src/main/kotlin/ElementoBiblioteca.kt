package org.pebiblioteca

interface Prestable{
    fun prestar(libro: Libro)

    fun devolver(libro: Libro)
}


abstract class ElementoBiblioteca(var id: Int, var titulo: String, var estado: Estado = Estado.DISPONIBLE) {
}