package Level3
var answer : Long =0
fun longJumpSolution(n: Int): Long {
    jump(n,0,1) //시작을 1칸
    jump(n,0,2) //시작을 2칸
    println(answer)
    return answer
}
fun jump(n:Int,dis:Int,degree:Int){//가야하는거리,간거리,가는정도
    if(dis+degree==n){
        answer++
        return
    }else if(dis+degree >n){
        return
    }else {
        jump(n,dis+degree,1)
        jump(n, dis+degree, 2)
        return
    }
}
fun main(){
longJumpSolution(3)
}