package Level1
fun descendingStringSolution(s: String): String {
    return s.map { it }.sortedByDescending { it }
            .joinToString("")
  /*
        참고하기.
        return  String(s.toCharArray().sortedArrayDescending())
   */



}
fun main(){
    println(descendingStringSolution("Zbcdefg"))
}