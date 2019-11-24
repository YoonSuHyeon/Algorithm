package Level1
fun gcdAndLcmSolution(n: Int, m: Int): IntArray {
    var answer = Array(2){0}.toIntArray()
    if(n<m){
        for(i in 1 ..n) {
            if(n%i==0 &&m%i==0) answer[0]=i //최대 공약수
        }
        for(i in m*n downTo m-1){
            if(i%m ==0 && i%n ==0) answer[1]=i // 최소 공배수
        }
    }else{

        for(i in 1 ..m) {
            if(n%i==0 &&m%i==0) answer[0]=i
        }
        for(i in m*n downTo n-1){
            if(i%m ==0 && i%n ==0) answer[1]=i
        }
    }
    return answer
}
fun main(){
    gcdAndLcmSolution(9,3)
}