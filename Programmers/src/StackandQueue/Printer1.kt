package StackandQueue

fun printer2Solution(priorities: IntArray, location: Int): Int {
    var temp =priorities.zip(priorities.indices)
    var count =0
    while(true){
        var index = temp.indexOfFirst { temp.maxBy { it.first } == it }
        count++
        if(temp[index].second==location) break;
        temp=temp.subList(index+1,temp.size)+temp.subList(0,index)
    }
    return count
}
fun main(){
    printer2Solution(intArrayOf(1,1,9,1,1,1),0)
}