package Level3
var arr=IntArray(50,{500001})
fun nTownSolution(N: Int, road: Array<IntArray>, k: Int): Int {
    var answer = 0

    var temp =road.filterIndexed { index, ints -> (ints[0]==1||ints[1]==1)&&ints[2]<=k  }
    temp.forEach {
        if(it[0]==1){
            onetoN(it[1],road,it[2],k)
        }else{
            onetoN(it[0],road,it[2],k)
        }


    }
    answer=arr.count{ it!=500001}
    println(answer+1)
    return answer+1
}
fun onetoN(one:Int,road: Array<IntArray>,weight:Int,k:Int){
    if(weight>k) return
    if(weight<arr[one]){
        arr[one]=weight
    }
    val temp=road.filterIndexed { index, ints -> (ints[0]==one||ints[1]==one)&&ints[2]+weight<=k }
    temp.forEach {
        if(it[0]==one){
            onetoN(it[1],road,it[2]+weight,k)
        }else{
            onetoN(it[0],road,it[2]+weight,k)
        }

    }
}
fun main(){
    nTownSolution(5, arrayOf(intArrayOf(1,2,1), intArrayOf(2,3,3), intArrayOf(5,2,2), intArrayOf(1,4,2), intArrayOf(5,3,1),
            intArrayOf(5,4,2))
            ,3)
}