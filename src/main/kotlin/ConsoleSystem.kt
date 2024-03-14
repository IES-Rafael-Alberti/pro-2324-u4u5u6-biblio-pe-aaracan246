package org.pebiblioteca

    interface Sender {
        fun printer(msgToPrint: String)
    }

    interface Reader {
        fun reader(): String
    }


    object ConsoleSystem : Sender, Reader {


        override fun printer(msgToPrint: String) {
            println(msgToPrint)
        }


        override fun reader(): String {
            //var msgToRead = readln()
            return readln()
        }

        fun menuUsuario(){
            println("Menú de usuario:")
            println("1. Añadir libro al catálogo.")
            println("2. Eliminar libro del catálogo.")
            println("3. Salir")

        }
    }
