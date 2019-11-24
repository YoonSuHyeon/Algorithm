package KaKao
fun failureRateSolution(N: Int, stages: IntArray): IntArray {

    var temp = Array<Double>(N,{i ->0.0 })// 실패율을 구하기 위한 temp
    var passtemp:Int
    var trytemp:Int

    for(i in 1..N){
         passtemp =stages.count { i<it } //통과한사람의수
         trytemp=stages.count { i<=it } //문제를 도전한 사람의수
        temp[i-1]=1.0-(passtemp.toDouble() /trytemp.toDouble())

        if(stages.count{i<=it}==0){ //문제에 도달하지 못했을 때에는 0으로 처리 .
            temp[i-1] =0.0
        }
    }

    var answer =Array(temp.size,{i->i+1}).zip(temp).sortedByDescending { it.second }
            .map { it.first }
            .toIntArray()

    return answer
}
fun main(){
    var n = 5
    var stages = intArrayOf(4,4,4,4)
    failureRateSolution(n,stages )
}