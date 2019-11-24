package Level1
fun descendingNumSolution(n: Long): Long {
    return n.toString().map { it.toString() }.sortedByDescending {it.toInt()}.joinToString("").toLong()

}
fun main(){
    descendingNumSolution(118372)
}