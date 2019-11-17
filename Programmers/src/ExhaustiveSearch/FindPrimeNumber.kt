package ExhaustiveSearch

import kotlin.math.max
lateinit var combNumbers : MutableList<Int>
fun temp(numbers:String,result:String) {
    if (!result.isNullOrEmpty()) {
        combNumbers.add(result.toInt())
    }

    if (numbers.isEmpty()) {
        return
    }
    numbers.forEachIndexed { index, c ->
        temp((numbers.removeRange(index..index)), result + c)
    }
}
    fun isPrime(num:Int):Boolean{

        if(num == 1 || num == 0 ){return false}
        for(i in 2..num/2){
            if(num%i == 0){
                return false
            }
        }
        return true
    }
fun findPrimeNumbersolution(numbers: String): Int {
    var answer = 0
    combNumbers = mutableListOf()

    temp(numbers,"")

    combNumbers.distinct().forEach {

        if(isPrime(it)){
            answer++
        }
    }
    return answer


}


fun main(){

    findPrimeNumbersolution("011")
}
