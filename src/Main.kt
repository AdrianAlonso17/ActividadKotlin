//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    print("Introduce la primera palabra: ")
    val palabra1 = readLine()!!.toLowerCase().trim()

    print("Introduce la segunda palabra: ")
    val palabra2 = readLine()!!.toLowerCase().trim()

    if (sonAnagramas(palabra1, palabra2)) {
        println("Las palabras '$palabra1' y '$palabra2' son anagramas.")
    } else {
        println("Las palabras '$palabra1' y '$palabra2' no son anagramas.")
    }
}

fun sonAnagramas(palabra1: String, palabra2: String): Boolean {
    if (palabra1.length != palabra2.length) {
        return false
    }

    val lista1 = palabra1.toList().sorted()
    val lista2 = palabra2.toList().sorted()

    return lista1 == lista2
}
