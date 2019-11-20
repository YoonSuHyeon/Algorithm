package Level1

fun getCenterCharacterSolution(s: String): String {
    var answer = ""
    if(s.length % 2 == 0)
        answer = s[s.length/2-1].toString()+s[s.length/2]
    else
        answer = s[s.length/2].toString()
    return answer
}
fun main(){
    println(getCenterCharacterSolution("abcde"))
    println(getCenterCharacterSolution("qwer"))
}