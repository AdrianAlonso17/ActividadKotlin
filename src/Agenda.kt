class Agenda(private val maxContactos: Int = 10) {
    private val contactos = mutableListOf<Contacto>()

    // Añadir un contacto
    fun agregarContacto(contacto: Contacto) {
        if (contactos.size >= maxContactos) {
          println("La agenda esta llena no se pueden meter mas contactos ")
            //Convierto los nombres a minusculas para comprobar si es el mismo nombre
        } else if (contactos.any { it.nombre.toLowerCase() == contacto.nombre.toLowerCase() }) {
            println("El contacto con ese nombre ya existe")
        } else {
            contactos.add(contacto)
            println("Se ha añadido el contacto")
        }
    }

    // Listar todos los contactos
    fun listarContactos() {
        if (contactos.isEmpty()) {
            println("No hay contactos que mostrar")
        } else {
            contactos.forEach { println("Nombre=${it.nombre}, Telefono=${it.telefono}") }
        }
    }

    // Buscar un contacto por el nombre
    fun buscarContacto(nombre: String) {
        //Utilizo el metodo fin para poder encontrar en mis contactos algun contacto con el mismo nombre que me estan pasando
        val contacto = contactos.find { it.nombre == nombre }
        if (contacto != null) {
            println("Su telefono es ${contacto.telefono}.")
        }else{
            println("No se ha encontrado el contacto")
        }
    }

    // Comprobar si un contacto existe a traves de un nombre
    fun comprobarContacto(nombre: String): Boolean {
        return contactos.any { it.nombre == nombre }
    }

    // Eliminar un contacto a traves de un nombre
    fun eliminarContacto(nombre: String) {
        val contacto = contactos.find { it.nombre == nombre }
        if (contacto != null) {
            contactos.remove(contacto)
            println("Se ha eliminado el contacto")
        } else {
            println("No se ha eliminado el contacto")
        }
    }

    // Indica el numero de contactos que puedes añadir
    fun huecos() {
        println("Hay ${maxContactos - contactos.size} contacto/s libre/s")
    }

    // Comprobar si la agenda está llena
    fun estaLlena(): Boolean {
        return contactos.size >= maxContactos
    }
}
