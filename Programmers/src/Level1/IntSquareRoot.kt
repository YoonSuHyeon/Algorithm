package Level1
fun intSquareRootSolution(n: Long): Long {
    var answer:Long = 0
    for(i in 1..n){
        if(i*i>n){
            answer =-1
            break
        }
        if(i*i==n) {
            answer=(i+1)*(i+1)
            break
            }
    }
    return answer
    /*  val sqrt = Math.sqrt(n.toDouble())
        return if(sqrt % 1.0 == 0.0) {
            Math.pow(sqrt + 1, 2.0).toLong()
        } else {
            -1L
        }*/
}
fun main(){
    intSquareRootSolution(121)
}