package Level1

fun numbersIntoArraysSolution(n: Long): IntArray {
    var answer=ArrayList<Int>()
    n.toString().reversed().forEach {
        answer.add(it.toString().toInt())
    }
    return answer.toIntArray()
}

fun main(args : Array<String>){
   numbersIntoArraysSolution(12345).forEach { println(it) }
}