package Level2
fun fibonacciSequenceSolution(n: Int): Int {
    var temp1:Long =0
    var temp2 :Long=1
    var answer:Long =0
    if(n==0 ||n==1){
        return n%1234567
    }else{
        for(i in 2..n){
            answer=temp1%1234567+temp2%1234567
            temp1=temp2%1234567
            temp2=answer%1234567
        }
        return (answer%(1234567.toLong())).toInt()
    }



}
fun main(){
    println(fibonacciSequenceSolution(12345678))
}