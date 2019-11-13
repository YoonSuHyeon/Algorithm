package Level1

fun yearsolution(a: Int, b: Int): String {
    var answer = ""
    val temp= intArrayOf(31,29,31,30,31,30,31,31,30,31,30,31)
    val tempstring = arrayOf("THU","FRI","SAT","SUN","MON","TUE","WED")
    var sum=b //총일수를 구하기위해 월 일 중 일의값을 넣어준다

    for (i in 0 until a-1){ // 총일수를 구한다
        sum+=temp[i]
    }

    return tempstring[sum%7]
}

fun main(){
    println( yearsolution(5,24))
}