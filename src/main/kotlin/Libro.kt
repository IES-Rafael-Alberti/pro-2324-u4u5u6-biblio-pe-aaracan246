package org.pebiblioteca
enum class Estado{
    DISPONIBLE, PRESTADO
}
data class Libro(var id: Int, var titulo: String, var autor: String, var fechaPubli: Int, var tematica: String, var estado: Estado = Estado.DISPONIBLE) {
}