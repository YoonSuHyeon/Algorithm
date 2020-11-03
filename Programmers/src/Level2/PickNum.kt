package Level2

fun solution(numbers: IntArray): IntArray {
    var temp=HashSet<Int>()
    for(i in numbers.indices){
        for(j in i+1 until  numbers.size){
            temp.add(numbers[i]+numbers[j])
        }
    }


    return temp.sorted().toIntArray()
}
fun main(){
    solution(intArrayOf(2,1,3,4,1))
}