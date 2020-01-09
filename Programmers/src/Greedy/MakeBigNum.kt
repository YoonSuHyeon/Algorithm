package Greedy
fun makeBigNumSolution(number: String, k: Int): String {
    var answer = ""
    var stringSize = number.length - k  //구해야 길이
    var index = 0
    val list = mutableListOf<Char>()
    while (stringSize > 0) {
        val string = number.substring(index, number.length - (stringSize - 1))  // 구해지는값 + 나머지값을 남겨둬야하기때문.
        string.max()?.let {max ->
            index += string.indexOf(max) + 1
            list.add(max)
        }
        stringSize -= 1
    }
    answer = list.joinToString("")
    return answer
}

fun main(){
    makeBigNumSolution("4177252841",4)
}
