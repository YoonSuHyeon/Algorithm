package Level1
fun sumOfDivisorsSolution(n: Int): Int {
    var answer = 0
    for(i in 1 .. n){
        if(n%i == 0){
            answer +=i
        }
    }
    return answer
}
fun main(){
    println(sumOfDivisorsSolution(12))
    println(sumOfDivisorsSolution(5))
}
