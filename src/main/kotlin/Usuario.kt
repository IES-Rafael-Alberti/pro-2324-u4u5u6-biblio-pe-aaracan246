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

class RegistroPrestamos(): GestorBiblioteca(){
    private val historialRegistros = mutableMapOf<Libro, Usuario>()

    fun devolverPrestamo(libro: Libro, usuario: Usuario){
        GestorBiblioteca().catalogoLibros.add(libro)
        usuario.removeLibro(libro)
        historialRegistros[libro] = usuario
    }

    fun prestar(libro: Libro, usuario: Usuario){
        GestorBiblioteca().catalogoLibros.remove(libro)
        usuario.addLibro(libro)
        historialRegistros[libro] = usuario
    }


}