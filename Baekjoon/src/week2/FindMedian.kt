package week2

import java.util.*
fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val times = input.nextInt() //횟수
    for (i in 0 until times) {
        var maxHeap = PriorityQueue<Int>(Collections.reverseOrder())
        var minHeap = PriorityQueue<Int>()
        var count=0
        val inputTime = input.nextInt() //갯수
        println((inputTime+1)/2)
        for(j in 1 .. inputTime){
            val num = input.nextInt()

            if(maxHeap.size == minHeap.size){
                maxHeap.add(num)
            }else{
                minHeap.add(num)
            }
            if(!maxHeap.isEmpty()){
                if(!minHeap.isEmpty()){
                    if(maxHeap.peek() > minHeap.peek()){
                        val temp1 = maxHeap.poll()
                        val temp2 = minHeap.poll()
                        maxHeap.add(temp2)
                        minHeap.add(temp1)
                    }
                }
            }
            if(j%2 == 1){
                print("${maxHeap.peek()} ")
                count++

                if(count %10 == 0){
                    println()
                }
            }

        }
        println()
    }
}