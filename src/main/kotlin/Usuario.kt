package org.pebiblioteca

class Usuario(val id: Int, val nombre: String){

    constructor(id: Int, nombre: String, listaLibrosEnPosesion: MutableList<Libro>) : this(id, nombre){

        fun mostrarLibrosEnPosesion() = "El usuario ${this.id}, de nombre ${this.nombre} tiene actualmente los siguientes ejemplares: $listaLibrosEnPosesion."

        fun removeLibro(libro: Libro){
            listaLibrosEnPosesion.remove(libro)
        }

        fun addLibro(libro: Libro){
            listaLibrosEnPosesion.add(libro)
        }
    }
}