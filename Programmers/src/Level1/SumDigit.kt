package Level1

fun sumDigitSolution(n: Int): Int {
   return n.toString().map { it.toString() }.sumBy { it.toInt() }

}
fun main(){
    sumDigitSolution(123)
}