fun main() {
    val sistema = Agenda()

    while (true) {
        mostrarMenu()
        println("Escribe una de las opciones")
        val num= readln()
        when (num.toInt()) {
            1 -> {
                println("Escribe el nombre del contacto:")
                val nombre = readLine()!!
                println("Escribe el telefono del contacto:")
                val telefono = readLine()!!
                val contacto = Contacto(nombre, telefono)
                sistema.agregarContacto(contacto)
            }
            2 -> sistema.listarContactos()
            3 -> {
                println("Escribe un nombre")
                val nombre = readLine()!!
                sistema.buscarContacto(nombre)
            }
            4 -> {
                println("Escribe un nombre")
                val nombre = readLine()!!
                if (sistema.comprobarContacto(nombre)) {
                    println("El contacto existe")
                } else {
                    println("El contacto no existe")
                }
            }
            5 -> {
                println("Escribe el nombre de contacto a eliminar")
                val nombre = readLine()!!
                sistema.eliminarContacto(nombre)
            }
            6 -> sistema.huecos()
            7 -> {
                if (sistema.estaLlena()) {
                    println("La agenda esta llena")
                } else {
                    println("Aun se pueden meter contactos")
                }
            }
            8 -> {
                break
            }
            else -> println("Seleccione una opcion valida")
        }
    }
}

fun mostrarMenu() {
    println("1. Añadir contactos")
    println("2. Listar contactos")
    println("3. Buscar un contacto")
    println("4. Existe contacto")
    println("5. Eliminar un contacto")
    println("6. Contactos disponibles")
    println("7. Agenda llena")
    println("8. Salir")
}


