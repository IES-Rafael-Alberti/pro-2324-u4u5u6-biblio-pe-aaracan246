package org.pebiblioteca
enum class Estado{
    DISPONIBLE, PRESTADO
}
data class Libro(val id: Int, val titulo: String, val autor: String, val fechaPubli: Int, val tematica: String, var estado: Estado = Estado.DISPONIBLE) {
}