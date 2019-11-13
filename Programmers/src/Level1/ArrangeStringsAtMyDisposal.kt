package Level1

fun ArrangeStringsAtMyDisposalsolution(strings: Array<String>, n: Int): Array<String> {

    return strings.sortedBy { it }
            .sortedBy { it[n] }
            .toTypedArray()

}
fun main(){
    var temp = arrayOf("abce", "abcd", "cdx")
    ArrangeStringsAtMyDisposalsolution(temp	,2).forEach { println(it) }
}