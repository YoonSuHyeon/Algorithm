package ExhaustiveSearch


fun carpetSolution(brown: Int, red: Int): IntArray {
    var answer = intArrayOf(0,0)
    var temp=ArrayList<Int>()//red 세로의길이
    for(i in 1..red){
        if(i>red/i){
            break
        }
        else if(red/i * i == red){
            temp.add(i)
        }
    }
    var temp1 = temp.filter { (2*it)+(red/it)*2+4 ==brown }

    answer[0]= red/temp1[0]+2
    answer[1]= temp1[0]+2
    return answer
}
/*
*
* fun solution(brown: Int, red: Int): IntArray {
        return (1..red)
            .filter { red % it == 0 }
            .first { brown == (red / it * 2) + (it * 2) + 4 }
            .let { intArrayOf(red / it + 2, it + 2) }
    }
* */
fun main(){
    carpetSolution(10,2)
}