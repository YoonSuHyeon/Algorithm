package Greedy
fun makeBigNumSolution(number: String, k: Int): String {
    var answer = ""
    var temp =ArrayList<String>()
    for(i in number){
        temp.add(i.toString())
    }
    for(i in 0 until k){
        answer+=temp.max()
        temp.remove(temp.max())
    }
    return answer
}
fun main(){
    makeBigNumSolution("1924",2)
}
