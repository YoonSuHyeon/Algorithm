package Level2
fun expectedDrawSolution(n: Int, a: Int, b: Int): Int {
    var answer = 1
    var tempA= a
    var tempB =b
    while(true){
        if(((tempA+1)/2) == ((tempB+1)/2) ) return answer
        else{
                tempA=(tempA+1)/2
                tempB=(tempB+1)/2
                answer++
            }
    }
}
fun main(){
    expectedDrawSolution(8,4,7)
}