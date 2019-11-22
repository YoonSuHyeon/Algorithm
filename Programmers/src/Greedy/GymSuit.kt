package Greedy
fun gymSuitSolution(n: Int, lost: IntArray, reserve: IntArray): Int {
    val tempmap =(Array(n) {true})
    val losttemp = lost.toMutableList()
    val reservetemp=reserve.toMutableList()

    for(i in 0 until reserve.size){  //여벌 체육복을 가져온 학생이 체육복을 도난 당했을시.
        for (j in 0 until lost.size){
            if(reserve[i]==lost[j]) {
                losttemp.remove(reserve[i])
                reservetemp.remove(reserve[i])
                break
            }
        }
    }
    for(i in 0 until losttemp.size){ //잃어버린사람을  false로 만든다.
        tempmap[losttemp[i]-1]=false
    }

    for(i in 0 until reservetemp.size){
        if(reservetemp[i]==1){
            if(!tempmap[reservetemp[i]])  {
                tempmap[reservetemp[i]]=true
            }
        }else if(reservetemp[i]==n){
            if(!tempmap[reservetemp[i]-2]) {
                tempmap[reservetemp[i]-2]=true
            }
        }else{
            if(!tempmap[reservetemp[i]-2]){
                tempmap[reservetemp[i]-2]=true
            }else if(!tempmap[reservetemp[i]]){
                tempmap[reservetemp[i]]=true
            }
        }
    }
    return tempmap.filter { it }.count()
}
fun main(){
    val lost = intArrayOf(2,3,4)
    val reserve = intArrayOf(1,2,3,6)
    gymSuitSolution(6,lost,reserve)
}