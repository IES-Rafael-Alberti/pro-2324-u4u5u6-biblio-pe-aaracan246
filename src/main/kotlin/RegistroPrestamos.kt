package org.pebiblioteca

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