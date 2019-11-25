package Test

fun example1Solution(s: String): String {

    var answer =s.mapIndexed { index, c -> if(index==0 ||s[index-1]==' ') c.toUpperCase().toString()
    else{
        c.toLowerCase().toString()
    }
    }.joinToString("")
    return answer
}
fun main(){
    example1Solution("3people unFollowed me")
}