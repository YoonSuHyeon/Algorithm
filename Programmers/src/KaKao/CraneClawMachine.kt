package KaKao

fun solution(board: Array<IntArray>, moves: IntArray): Int {
    var answer = 0
    var temp=ArrayList<Int>()
    moves.forEach {
        for(i in board.indices){
            if(board[i][it-1] !=0){
                if(temp.size !=0){
                    if(temp[temp.size-1] ==board[i][it-1]){
                        temp.removeAt(temp.size-1)
                        answer+=2
                    }else{
                        temp.add(board[i][it-1])
                    }
                }else{
                    temp.add(board[i][it-1])
                }

                board[i][it-1]=0
                break
            }

        }
    }

    return answer
}
fun main(){
    solution(arrayOf(
            intArrayOf(0,0,0,0,0),
            intArrayOf(0,0,1,0,3),
            intArrayOf(0,2,5,0,1),
            intArrayOf(4,2,4,4,2),
            intArrayOf(3,5,1,3,1))
            , intArrayOf(1,5,3,5,1,2,1,4))
}