//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val casosDePrueba = listOf(
        Pair(arrayOf("correr", "saltar", "correr", "saltar", "correr"), "_|_|_"),
        Pair(arrayOf("correr", "correr", "correr", "saltar", "correr"), "_|_|_"),
        Pair(arrayOf("correr", "correr", "saltar", "saltar", "correr"), "_|_|_"),
        Pair(arrayOf("correr", "correr", "saltar", "saltar", "correr"), "_|_|_|_"),
        Pair(arrayOf("correr", "saltar", "correr", "saltar"), "_|_|_"),
        Pair(arrayOf("correr", "saltar", "correr", "saltar", "correr", "saltar", "correr"), "_|_|_"),
        Pair(arrayOf("saltar", "saltar", "saltar", "saltar", "saltar"), "|||||"),
        Pair(arrayOf("saltar", "saltar", "saltar", "saltar", "saltar"), "||_||")
    )

    for (i in casosDePrueba) {
        val resultado = evaluarCarrera(i.first, i.second)
        println("$resultado")
    }
}

fun evaluarCarrera(acciones: Array<String>, pista: String): String {
    val pistaMutable = pista.toMutableList()

    for (i in acciones.indices) {
        if (i >= pistaMutable.size) break

        val accion = acciones[i]

        when {
            accion == "correr" && pistaMutable[i] == '_' -> pistaMutable[i] = '_'
            accion == "saltar" && pistaMutable[i] == '|' -> pistaMutable[i] = '|'
            accion == "saltar" && pistaMutable[i] == '_' -> pistaMutable[i] = 'x'
            accion == "correr" && pistaMutable[i] == '|' -> pistaMutable[i] = '/'
            else -> pistaMutable[i] = '?'
        }
    }

    return pistaMutable.joinToString("")
}






