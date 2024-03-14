package org.pebiblioteca

class GestorBiblioteca: UtilidadesBiblioteca(){
    private val catalogoLibros = mutableListOf<Libro>()
    //val registroPrestamos = mutableListOf()

    fun elegirMenu(libro: Libro){
        val selection = ConsoleSystem.reader()

        while (selection.toInt() != 3)
            when(selection.toInt()){

                1 -> solicitarDatosLibro(libro)

                2 -> removeLibro(libro)

                else -> return ConsoleSystem.printer("Saliendo del programa.")
            }
    }

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
        generateID()
    }


    /**
     * @param libro
     *
     * Añade un libro al catálogo.
     * */
    fun addLibro(libro: Libro){
        generateID()
        libro.id = generateID()
        catalogoLibros.add(libro)
        ConsoleSystem.printer("¡${libro.titulo} ha sido agregado al catálogo con éxito!")
    }

    /**
     * @param libro
     *
     * Elimina un libro del catálogo.
     * */
    fun removeLibro(libro: Libro){
        catalogoLibros.remove(libro)
        ConsoleSystem.printer("¡${libro.titulo} ha sido eliminado del catálogo con éxito!")
    }

    /**
     * @param libro
     *
     * Cambia el estado de un libro DISPONIBLE a PRESTADO.
     * */
    fun registrarPrestamo(libro: Libro){
        if (libro.estado == Estado.DISPONIBLE){
            libro.estado = Estado.PRESTADO
            ConsoleSystem.printer("Préstamo de ${libro.titulo} registrado.")
        }
        else{ ConsoleSystem.printer("${libro.titulo} ya está prestado.") }

    }

    /**
     * @param libro
     *
     * Cambia el estado de un libro PRESTADO a DISPONIBLE.
     * */
    fun devolverLibro(libro: Libro){
        if (libro.estado == Estado.DISPONIBLE){
            libro.estado = Estado.PRESTADO
            ConsoleSystem.printer("${libro.titulo} devuelto.")
        }
        else{ ConsoleSystem.printer("${libro.titulo} aún está disponible.")}
    }

    /**
     * @param id
     *
     * @return Boolean
     *
     * Comprueba si el libro existe en el catálogo.
     * */
    fun checkDisponibilidadLibro(id: Int): Boolean{
        if (catalogoLibros.find { it.id == id } != null){
            return true
        }
        else{
            return false
        }

    }


    //Creo que esto está mal porque no imprime el catálogo. Luego lo checkeo!!!!!!!!!!
    /**
     * @param id,
     *
     * Devuelve el catálogo según las condiciones de los libros (en base a su estado).
     * */
    fun retornarEstadosLibro(id: Int){
        if (catalogoLibros.find { it.id == id } != null){
            ConsoleSystem.printer("Todos los libros: $catalogoLibros.")
        }
        if (catalogoLibros.find { it.estado == Estado.DISPONIBLE } != null){
            ConsoleSystem.printer("Los libros disponibles: $catalogoLibros.")
        }
        if (catalogoLibros.find { it.estado == Estado.PRESTADO } != null){
            ConsoleSystem.printer("Los libros prestados: $catalogoLibros.")
        }
    }
}
