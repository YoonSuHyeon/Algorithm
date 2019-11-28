package Sort
fun maxSolution(numbers: IntArray): String {
    return numbers.map { it.toString() }
            .sortedByDescending { it[0] }
            .joinToString("")

}
fun main(){
    var numbers = intArrayOf(3,30,34,5,9)
    println(maxSolution(numbers))
}