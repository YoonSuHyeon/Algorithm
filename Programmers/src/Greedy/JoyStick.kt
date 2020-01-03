package Greedy
fun joyStickSolution(name: String): Int {
    var answer = 0
    val sample =HashMap<Char,Int>()
    var i='A'
    var count= 0
    //(0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1) //알파벳순 최소 움직이는 수
    for(i in 'A'..'N'){
        sample[i] = count++
    }
    count =12
    for(i in 'O'..'Z'){
        sample[i] = count--
    }

    name.forEach { if(it=='A'){
        answer += sample[it]!!-1
    }else{
        answer += sample[it]!!
    }}
    answer+=name.length-1
    return answer

}
fun main(){
    joyStickSolution("JAN")
}