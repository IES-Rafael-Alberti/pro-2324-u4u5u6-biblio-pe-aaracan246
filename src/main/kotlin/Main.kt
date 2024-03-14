package org.pebiblioteca

fun main() {

    val libro1 = Libro(133, "City of Glass", "Paul Auster", 1992, "Detectivesca", Estado.DISPONIBLE)
    val libro2 = Libro(134, "The Mark on the Wall", "Virginia Woolf", 1981, "Psicológica", Estado.PRESTADO)
    val libro3 = Libro(135, "Brave New World", "Aldous Huxley", 1966, "Ficción", Estado.PRESTADO)
    val libroIndeterminado = Libro(0, "Placeholder", "Placeholder", 1500, "Placeholder")

    val usuario1 = Usuario(15, "Paco")
    val usuario2 = Usuario(16, "Raúl")
    val usuario3 = Usuario(17, "Alberto")


    val gestorBiblioteca = GestorBiblioteca()

    // Añadimos los libros al catálogo:
//    gestorBiblioteca.addLibro(libro1, usuario1)
//    gestorBiblioteca.addLibro(libro2, usuario2)
//    gestorBiblioteca.addLibro(libro3, usuario3)

    ConsoleSystem.printer("__________")


    RegistroPrestamos().devolverPrestamo(libro3, usuario3)
    RegistroPrestamos().prestar(libro1, usuario2)

    usuario2.mostrarLibrosEnPosesion()

}