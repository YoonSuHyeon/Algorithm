package StackandQueue

fun FunctionDevelopmentsolution(progresses: IntArray, speeds: IntArray): IntArray {
   var temp = ArrayList<Int>()
    val answer = intArrayOf()
    for(i in progresses.indices){
        var count =0
        while(progresses[i]<100){
            count++
            progresses[i]+=speeds[i]
        }
        if(temp.size!=0){
            if(temp.get(i-1)>=count){
                count =temp.get(i-1)
            }
        }
        temp.add(count)
    }

    var templist = ArrayList<Int>()
    while(temp.any()){

     var samecount= temp.takeWhile { it ==temp[0] }
             .count()
        templist.add(samecount)
        for(i in 0 until samecount){
            temp.removeAt(0)
        }


    }
    return templist.toIntArray()






}
fun main(){
    val progresses = intArrayOf(93,30,55,93)
    val speeds = intArrayOf(1,30,5,1)
    FunctionDevelopmentsolution(progresses,speeds).forEach { println(it) }
}