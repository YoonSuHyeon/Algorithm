package DFS_BFS
var answer = 0
fun targetNumSolution(numbers: IntArray, target: Int): Int {

    dfs(numbers,target,0,0)
    return answer
}

fun dfs(numbers: IntArray,target: Int,sum:Int,index:Int){
    if(index==numbers.size){
        if(target==sum) {
            answer++
        }
        return
    }
    dfs(numbers,target,sum+numbers[index],index+1)
    dfs(numbers,target,sum-numbers[index],index+1)

}

fun main(){
    println(targetNumSolution(intArrayOf(1,1,1,1,1),3))
}