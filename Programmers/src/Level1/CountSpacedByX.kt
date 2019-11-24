package Level1
fun countSpacedByXSolution(x: Int, n: Int): LongArray {
    return  Array(n) {i ->x*(i+1).toLong()}.toLongArray()
}
fun main(){
    countSpacedByXSolution(2,5)
}