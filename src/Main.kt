//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    comprobarExpresion("{a + b [c] * (2x2)}}}}")
    comprobarExpresion("{ [ a * ( c + d ) ] - 5 }")
    comprobarExpresion("{ a * ( c + d ) ] - 5 }")
    comprobarExpresion("{a^4 + (((ax4)}")
    comprobarExpresion("{ ] a * ( c + d ) + ( 2 - 3 )[ - 5 }")
    comprobarExpresion("{{{{{{(}}}}}}")
    comprobarExpresion("(a")
}

fun comprobarExpresion(cadena: String) {
    val mapa=mutableListOf<Char>()
    var balanceada=true

    for (i in cadena) {
        when (i) {
            '{', '[', '(' -> mapa.add(i)
            '}', ']', ')' -> {
                if (mapa.isEmpty()) {
                    balanceada=false
                } else {
                    val ultimo=mapa.removeAt(mapa.size - 1)

                    if ((i == '}' && ultimo != '{') ||
                        (i == ']' && ultimo != '[') ||
                        (i == ')' && ultimo != '(')
                    ) {
                        balanceada=false
                    }
                }
            }
    }
}
