package Sort
fun maxSolution(numbers: IntArray): String {
    var temp = numbers.sortedWith(Comparator({num1: Int, num2:Int -> "$num2$num1".compareTo("$num1$num2")}))
            .joinToString("")
    if(temp[0]=='0') return "0"
    return  temp
}
fun main(){
    var numbers = intArrayOf(3,30,34,5,9)
    println(maxSolution(numbers))
}