package Level1
fun createStrangeCharacterssolution(s: String): String {
    var answer = s.split(" ").toMutableList()
    for(i in 0 until answer.size) {
        var temp= answer[i].mapIndexed { index, c ->
            if (index % 2 == 0) c.toUpperCase()
            else c.toLowerCase()
        }
                .toCharArray()
        answer[i]=String(temp)
    }
    var s= answer.joinToString(" ")

    return s
}
fun main(){
    createStrangeCharacterssolution("try hello world")
}
