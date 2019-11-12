package StackandQueue
fun ironRodsolution(arrangement: String): Int {
    var answer = 0
    var temp =ArrayList<Char>()
    var tempstring=arrangement.replace("()","*")
    for(i in tempstring.indices){
        when(tempstring[i]){
            '*'->answer += temp.size
            '('->temp.add(tempstring[i])
            else->{
                temp.removeAt(temp.size-1)
                answer++
            }
        }
    }
    return answer
}
fun main(){
    println(ironRodsolution("()(((()())(())()))(())"))
}