fun main() {
    val matriz1 = arrayOf(
        arrayOf("X", "O", "X"),
        arrayOf("O", "X", "O"),
        arrayOf("O", "O", "X")
    )

    val matriz2 = arrayOf(
        arrayOf("", "O", "X"),
        arrayOf("", "X", "O"),
        arrayOf("", "O", "X")
    )

    val matriz3 = arrayOf(
        arrayOf("O", "O", "O"),
        arrayOf("O", "X", "X"),
        arrayOf("O", "X", "X")
    )

    val matriz4 = arrayOf(
        arrayOf("X", "O", "X"),
        arrayOf("X", "X", "O"),
        arrayOf("X", "X", "X")
    )

    println(analizarMatriz(matriz1))  // X
    println(analizarMatriz(matriz2))  // Empate
    println(analizarMatriz(matriz3))  // O
    println(analizarMatriz(matriz4))  // Null
}

fun analizarMatriz(matriz: Array<Array<String>>): String {
    val filas = matriz.size
    val columnas = matriz[0].size
    var xGana = false
    var oGana = false
    var cuentaX = 0
    var cuentaO = 0
    var vacios = 0

    for (i in 0 until filas) {
        for (j in 0 until columnas) {
            when (matriz[i][j]) {
                "X" -> cuentaX++
                "O" -> cuentaO++
                "" -> vacios++
            }
        }
    }

    for (i in 0 until filas) {
        if (matriz[i].all { it == "X" }) xGana = true
        if (matriz[i].all { it == "O" }) oGana = true
    }

    for (j in 0 until columnas) {
        if (matriz.all { it[j] == "X" }) xGana = true
        if (matriz.all { it[j] == "O" }) oGana = true
    }

    if ((matriz[0][0] == "X" && matriz[1][1] == "X" && matriz[2][2] == "X") ||
        (matriz[0][2] == "X" && matriz[1][1] == "X" && matriz[2][0] == "X")) xGana = true
    if ((matriz[0][0] == "O" && matriz[1][1] == "O" && matriz[2][2] == "O") ||
        (matriz[0][2] == "O" && matriz[1][1] == "O" && matriz[2][0] == "O")) oGana = true

    if (xGana && oGana) return "Nulo"
    if (xGana) return "X"
    if (oGana) return "O"

    if (cuentaX + cuentaO == filas * columnas) return "Empate"

    if (cuentaX != cuentaO && cuentaX != (cuentaO + 1)) {
        return "Nulo"
    }

    return "Empate"
}
