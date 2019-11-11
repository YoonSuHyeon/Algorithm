package StackandQueue

import java.lang.Thread.enumerate

fun printer(priorities: IntArray, location: Int): Int {

    var ps = priorities.toMutableList()
    var curor = location
    var done = mutableListOf<Int>()
    while (ps.isNotEmpty()) {
        val f = ps.removeAt(0)
        curor--
        if( ps.indexOfFirst { it > f } != -1 ) {
            ps.add(f)
            if(curor == -1) curor = ps.size-1
        }else{
            done.add(f)
            if(curor == -1) {
                curor = done.size
                break
            }
        }
    }
    return curor


}
fun main(){

    val priorities= intArrayOf(1, 1, 9, 1,1,1)
    val location = 0
    println(printer(priorities,location))
}