package org.pebiblioteca

fun main() {

    val libro1 = Libro(133, "City of Glass", "Paul Auster", 1992, "Detectivesca", Estado.DISPONIBLE)
    val libro2 = Libro(134, "The Mark on the Wall", "Virginia Woolf", 1981, "Psicológica", Estado.PRESTADO)
    val libro3 = Libro(135, "Brave New World", "Aldous Huxley", 1966, "Ficción", Estado.PRESTADO)

    val gestorBiblioteca = GestorBiblioteca()

    // Añadimos los libros al catálogo:
    gestorBiblioteca.addLibro(libro1)
    gestorBiblioteca.addLibro(libro2)
    gestorBiblioteca.addLibro(libro3)

    ConsoleSystem.printer("__________")

    // Forzamos distintos tipos de devolución:
    gestorBiblioteca.devolverLibro(libro1)
    gestorBiblioteca.devolverLibro(libro3)

    ConsoleSystem.printer("__________")

    //Forzamos distintos tipos de préstamo:
    gestorBiblioteca.registrarPrestamo(libro1)
    gestorBiblioteca.registrarPrestamo(libro2)

    ConsoleSystem.printer("__________")

    gestorBiblioteca.checkDisponibilidadLibro(libro1.id)
    gestorBiblioteca.checkDisponibilidadLibro(libro2.id)
    gestorBiblioteca.checkDisponibilidadLibro(libro3.id)

    ConsoleSystem.printer("__________")
}