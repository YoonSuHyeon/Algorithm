package KaKao
fun LockAndKeySolution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
    var answer = true
    var keylist= ArrayList<Array<IntArray>>()
    keylist.add(key) //회전시킨것 총 4개를 넣는다.
    for(i in key.indices){
        for(j in key[i].indices){

        }
    }


    return answer
}


fun main(){
    LockAndKeySolution(arrayOf(intArrayOf(0,0,0), intArrayOf(1,0,0), intArrayOf(0,1,1))
    , arrayOf(intArrayOf(1,1,1), intArrayOf(1,1,0), intArrayOf(1,0,1)))
}