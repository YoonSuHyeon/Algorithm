package Level2

fun matrixMultiplicationSolution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
    var answer = Array(arr1.size){ IntArray(arr2[0].size)}
    var temp =0
    for (i in 0 until arr1.size){
        for(j in 0 until arr2[0].size){
            temp=0;
            for(k in 0 until arr1[0].size){
                temp+=arr1[i][k]*arr2[k][j]
            }
            answer[i][j]=temp
        }
    }

    return answer
}
fun main(){
     var arr1 =Array(3){IntArray(2)}
     arr1[0] = intArrayOf(1,4)
     arr1[1] = intArrayOf(3,2)
     arr1[2] = intArrayOf(4,1)

    var arr2 = Array(2){IntArray(2)}
    arr2[0] =  intArrayOf(3,3)
    arr2[1] =  intArrayOf(3,3)
    matrixMultiplicationSolution(arr1,arr2)
}