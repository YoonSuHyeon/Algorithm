package Level1
fun evenAndOddSolution(num: Int): String {
    var answer = ""

    when(num%2){
        0 -> answer="Even"
        1 -> answer="Odd"
        -1-> answer="Odd"  //음수일때도 계산을 해줘야한다..
    }
    return answer
}

fun main(){
    println(evenAndOddSolution(-1))
}