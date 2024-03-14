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

    }
