package Level1

import ExhaustiveSearch.findPrimeNumbersolution

fun findKimInSeoulsolution(seoul: Array<String>): String {

    var answer = seoul.indexOfFirst { it=="Kim"  }.toString()
    return "김서방은 "+answer+"에 있다"
}
fun main(){
    var seoul = arrayOf("Jane", "Kim")
    var temp = findKimInSeoulsolution(seoul)
    println(temp)
}