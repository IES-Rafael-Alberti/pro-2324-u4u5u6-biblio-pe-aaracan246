package org.pebiblioteca

class Usuario(id: Int, private val nombre: String): UtilidadesBiblioteca(){


    val listaLibrosEnPosesion = mutableListOf<Libro>()
    private var id = id
        set(value) {
            generateID()
            field = value
        }


    fun mostrarLibrosEnPosesion() = "El usuario ${this.id}, de nombre ${this.nombre} tiene actualmente los siguientes ejemplares: $listaLibrosEnPosesion."

    fun addLibro(libro: Libro){
        listaLibrosEnPosesion.add(libro)
    }

    fun removeLibro(libro: Libro){
        listaLibrosEnPosesion.remove(libro)
    }
}

