package Level1


fun watermelonSolution(n: Int): String {
    var answer = ""
    for(i in 1..n){
        if(i%2==0){
            answer+="박"
        }else{
            answer+="수"
        }
    }
    return answer
}
fun main(){
    println(watermelonSolution(4))
}