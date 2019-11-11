package StackandQueue
fun bridgetrucksolution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    var answer = 0
   //트럭은 1초에 1만큼 움직인다.

    var ready :ArrayList<Int> =truck_weights.toCollection(ArrayList<Int>()) //ArrayList로만듬
     var temp = ArrayList<ArrayList<Int>>()
    var ttt = ArrayList<Int>()
    var dkj =0 // 배열의 인덱스
    var sum =0
    while(dkj!=truck_weights.size-1){
        var tt = ready[dkj]
        var tx =ready[dkj+1]
        sum =tt+tx
        if(sum >weight){
            ttt.add(dkj)
            //temp[i][j]=dkj
            dkj++
            temp.add(ttt)
            ttt.clear()
            sum=0

        }else{
            temp.add(ttt)
            dkj++
        }
    }
    println(temp)

    return answer
}
fun main(){
    val bridge_length = 2
    val weight = 10
    val truck_weights = intArrayOf(7,4,5,6)
   bridgetrucksolution(bridge_length, weight, truck_weights)
}