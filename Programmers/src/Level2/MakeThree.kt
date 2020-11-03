package Level2

fun solution(n: Int): Int {
    var answer: Int = 0
    var temp =n
    val list=ArrayList<String>()
    while(temp !=0){//3진법 구하기
        list.add((temp%3).toString())
        temp /= 3
    }
    var tempString=list.joinToString("").reversed()
    var count = 1
    n.toString(3)
    for(i in tempString.indices){

        answer += (tempString[i].toString().toInt() * count)
        count*=3
    }
    return answer
}
fun main(){
    solution(125)
}