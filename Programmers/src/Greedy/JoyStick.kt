package Greedy
fun joyStickSolution(name: String): Int {
    var answerf = 0

    var temp = name.map { 'A' }.toMutableList()
    var i = 0
    while (true) { //앞으로
        if (temp.joinToString("") == name) {
            break
        }
        when {
            name[i] == 'A' -> {
                answerf++
            }
            name[i] > 'N' -> {
                answerf += (13 - (name[i] - 'N')) + 1
                temp[i] = name[i]
            }
            else -> {
                answerf += (name[i] - 'A') + 1
                temp[i] = name[i]
            }
        }
        i++
    }
    answerf--

    temp = name.map { 'A' }.toMutableList()
    var answer =0
    var j = 0
    while (true) {//뒤로
        if (temp.joinToString("") == name) {
            break
        }
        when {
            name[j] == 'A' -> {
                answer++
            }
            name[j] > 'N' -> {
                answer += (13 - (name[j] - 'N')) + 1
                temp[j] = name[j]
            }
            else -> {
                answer += (name[j] - 'A') + 1
                temp[j] = name[j]
            }
        }
        if(j==0)j=j+name.length-1
        else j--
    }
    answer--
    if(answerf<answer) answer=answerf
    println(answer)
    return answer


}
fun main(){
    joyStickSolution("AZAAAZ")
}