package StackandQueue
fun towersolution(heights: IntArray): IntArray{
    var answer = IntArray(heights.size) {0}
    for(i in (heights.size) downTo 1  ){

        for(j in i-1 downTo 1){
            if(heights[i-1]<heights[j-1]){
                answer[i-1]=j
                break;
            }
        }
    }
    return answer
}
 fun main(){
    var heights = intArrayOf(6,9,5,7,4)
     towersolution(heights).forEach { println(it) }
}