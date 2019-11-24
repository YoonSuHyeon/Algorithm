package Level1
fun harshadNumberSolution(x: Int): Boolean {
    var answer = true
    var temp = x.toString()
            .map { it.toString() }
            .toMutableList()
            .sumBy { it.toInt() }
    if(x%temp!=0) answer =false

    return answer
}
fun main(){
    println( harshadNumberSolution(10))
    println( harshadNumberSolution(12))
    println( harshadNumberSolution(11))
    println( harshadNumberSolution(13))
}