package Level1

fun DividingSequenceOfNumberssolution(arr: IntArray, divisor: Int): IntArray {

    var dd =arr.filter { it/divisor*divisor==it }
            .sortedBy { it }
            .toIntArray()
    return if(dd.isEmpty()) intArrayOf(-1) else dd



}
fun main(){
    val arr = intArrayOf(5, 9, 7, 10)
    DividingSequenceOfNumberssolution(arr,5).forEach { println(it) }
}