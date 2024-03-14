package org.pebiblioteca

class GestorBiblioteca{
    private val catalogoLibros = mutableListOf<Libro>()
    //val registroPrestamos = mutableListOf()



    /**
     * @param libro
     *
     * Añade un libro al catálogo.
     * */
    fun addLibro(libro: Libro){
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
