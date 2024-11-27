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
        println("${resultado.first} ${resultado.second}")
    }
}

fun evaluarCarrera(acciones: Array<String>, pista: String): Pair<String, Boolean> {
    val pistaMutable = pista.toMutableList()
    var carreraSuperada = true

    for (i in pistaMutable.indices) {
        if (i >= acciones.size) {
            pistaMutable[i] = '?'
            carreraSuperada = false
        } else {
            val accion = acciones[i]
            when {
                accion == "correr" && pistaMutable[i] == '_' -> pistaMutable[i] = '_'
                accion == "saltar" && pistaMutable[i] == '|' -> pistaMutable[i] = '|'
                accion == "saltar" && pistaMutable[i] == '_' -> {
                    pistaMutable[i] = 'x'
                    carreraSuperada = false
                }
                accion == "correr" && pistaMutable[i] == '|' -> {
                    pistaMutable[i] = '/'
                    carreraSuperada = false
                }
                else -> {
                    pistaMutable[i] = '?'
                    carreraSuperada = false
                }
            }
        }
    }

    return Pair(pistaMutable.joinToString(""), carreraSuperada)

}






