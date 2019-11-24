package Level1
fun matrixAdditionSolution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {

    val answer = Array(arr1.size) { IntArray(arr1[0].size) }


    for(i in 0 until arr1.size){
        for(j in 0 until arr1[0].size){
            answer[i][j]=arr1[i][j]+arr2[i][j]
        }
    }
    return answer
}
fun main(){

    var temp= intArrayOf(1,2)
    var temp2= intArrayOf(2,3)
    var arr1:Array<IntArray> = Array(2){ IntArray(2) }
    arr1[0]=temp
    arr1[1]=temp2
    var temp3 = intArrayOf(3,4)
    var temp4 = intArrayOf(5,6)
    var arr2:Array<IntArray> = Array(2) { intArrayOf(0,0)}
    arr2[0]=temp3
    arr2[1]=temp4
   matrixAdditionSolution(arr1,arr2)
}