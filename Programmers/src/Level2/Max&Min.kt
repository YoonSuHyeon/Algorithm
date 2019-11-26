package Level2

import java.util.*

fun maxMinSolution(s: String): String {
    var temp = StringTokenizer(s," ")
    var list = arrayListOf<String>()
    //var ss = s.split(" ")
    while(temp.hasMoreTokens())
    {
        list.add(temp.nextToken())
    }

    var max = list.map { it.toInt()}
            .max()
    var min=list.map{it.toInt()}
            .min()
    return min.toString()+" "+max.toString()

}
fun main(){
    maxMinSolution("-1 -2 -3 -4")
}