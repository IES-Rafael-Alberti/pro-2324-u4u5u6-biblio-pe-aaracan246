package org.pebiblioteca
enum class Estado{
    DISPONIBLE, PRESTADO
}

/**
 * Los atributos de libro serán privados para controlar su acceso salvo 'id' y 'título' que se requiere de su acceso en otras funciones.
 * */
class Libro(id: Int, nombre: String, private var autor: String, private var fechaPubli: Int, private var tematica: String): ElementoBiblioteca(id, nombre), Prestable{


    init {
        require(titulo.isNotBlank())
        require(autor.isNotBlank())
        require(fechaPubli in 1200..2024)
        require(tematica.isNotBlank())
    }

    override fun prestar(libro: Libro) {
        TODO("Not yet implemented")
    }

    override fun devolver(libro: Libro) {
        TODO("Not yet implemented")
    }


    /**
     * @param libro
     *
     * Solicita los distintos datos para identificar un libro nuevo. Además da la posibilidad de añadir al catálogo dicho libro (sé que esto atenta contra la responsabilidad única).
     * */
     fun solicitarDatosLibro(libro: Libro){

        ConsoleSystem.printer("Por favor, inserte el título del libro a ingresar en el catálogo: ")
        val newTitle = ConsoleSystem.reader()

        ConsoleSystem.printer("Por favor, inserte el autor del libro a ingresar en el catálogo: ")
        val newAuthor = ConsoleSystem.reader()

        ConsoleSystem.printer("Por favor, inserte el año del libro a ingresar en el catálogo: ")
        val newDate = ConsoleSystem.reader().toInt()

        ConsoleSystem.printer("Por favor, inserte la temática del libro a ingresar en el catálogo: ")
        val newTheme = ConsoleSystem.reader()

        libro.titulo = newTitle
        libro.autor = newAuthor
        libro.fechaPubli = newDate
        libro.tematica = newTheme
        UtilidadesBiblioteca.generateID()

        ConsoleSystem.printer("¡El libro ${libro.titulo} de ${libro.autor} ha sido identificado con éxito!")
        ConsoleSystem.printer("¿Desea añadir este libro al catálogo? (y/n)")
    }
}