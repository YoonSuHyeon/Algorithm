package Level1

fun sumBetweenTwoIntegerssolution(a: Int, b: Int): Long {
    var temp= if(a>b) b..a else a..b
    var answer :Long =0
    for(i in temp){
        answer+=i.toLong()
    }
    return  answer

}
fun main(){
    sumBetweenTwoIntegerssolution(3,5)
    sumBetweenTwoIntegerssolution(3,3)
    sumBetweenTwoIntegerssolution(5,3)
}