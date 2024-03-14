package org.pebiblioteca
interface IGestorPrestamos{


}
open class GestorBiblioteca: UtilidadesBiblioteca(){
    val catalogoLibros = mutableListOf<Libro>()
    //val registroPrestamos = mutableListOf()

    fun elegirMenu(libro: Libro){
        ConsoleSystem.menuUsuario()

        val selection = ConsoleSystem.reader()

            when(selection.toInt()){

                1 -> libro.solicitarDatosLibro(libro)

                2 -> removeLibro(libro)

                else -> return ConsoleSystem.printer("Saliendo del programa.")
            }
    }

    /**
     * @param libro
     *
     * Añade un libro al catálogo.
     * */
    fun addLibro(libro: Libro, usuario: Usuario){
        generateID()
        libro.id = generateID()
        usuario.listaLibrosEnPosesion
        catalogoLibros.add(libro)
        ConsoleSystem.printer("¡${libro.titulo} ha sido agregado al catálogo con éxito! Nuevo identificador único: ${libro.id}.")
    }

    /**
     * @param libro
     *
     * Elimina un libro del catálogo.
     * */
    private fun removeLibro(libro: Libro){
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
