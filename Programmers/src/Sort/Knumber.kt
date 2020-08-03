package Sort

fun KnumberSolution(array: IntArray, commands: Array<IntArray>): IntArray {

    var answer=ArrayList<Int>()

    for(i in commands.indices){
        var temp= array.map { it }
                .toMutableList()
                .filterIndexed { index, it ->
                    index in commands[i][0]-1 until commands[i][1]
                }
                .sortedBy { it }[commands[i][2]-1]
        answer.add(temp)
    }

    return answer.toIntArray()
}

fun main(args:Array<String>){
    KnumberSolution(intArrayOf(101,5,102,106,103,107,104),
            arrayOf(intArrayOf(2,5,3), intArrayOf(4,4,1), intArrayOf(1,7,3))).forEach { println(it) }

}