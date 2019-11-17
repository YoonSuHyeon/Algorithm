package Level1

fun createArraysolution(n: Long): IntArray {

   return n.toString()
           .reversed()
           .split("") //리스트로 만들어준다
           .filter { it !="" }
           .map { it.toInt() }
           .toIntArray()

}
fun main(){
    createArraysolution(12345).forEach { println(it) }
}