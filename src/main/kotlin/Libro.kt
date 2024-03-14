package org.pebiblioteca
enum class Estado{
    DISPONIBLE, PRESTADO
}
open class Libro(var id: Int, var titulo: String, var autor: String, var fechaPubli: Int, var tematica: String, var estado: Estado = Estado.DISPONIBLE) {

    init {
        require(titulo.isNotBlank())
        require(autor.isNotBlank())
        require(fechaPubli in 1200..2024)
        require(tematica.isNotBlank())
    }
}