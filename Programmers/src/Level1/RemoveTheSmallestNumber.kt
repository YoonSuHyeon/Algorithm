package Level1

fun removeTheSmallestNumberSolution(arr: IntArray): IntArray {
    if(arr.size==1) {
        arr[0] = -1
        return arr
    }

    return arr.filter { arr.min()!=it }
            .toIntArray()


}
fun main(){
    var arr = intArrayOf(4,3,2,1)
    removeTheSmallestNumberSolution(arr)
}