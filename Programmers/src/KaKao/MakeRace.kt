package KaKao

import java.util.*

class Solution {
    fun solution(board: Array<IntArray>): Int {
        var answer = 0
        //왼쪽 , 오른쪽 ,아래 ,cost

        var arrayList = ArrayList<Location>()
        var checked = Array<Array<Int>>(board.size) { Array<Int>(board.size) { i -> 0 } }
        checked[0][0] = 1

        //dir -1 을 두개다 가능 , 1 은 세로로   2 는 가로로
        arrayList.add(Location(0, 0, 0, -1))
        while (true) {

            val temp = arrayList[0]
            if (isLeftGo(temp, board)) {
                var tempCost = temp.cost
                //cost계산
                if (temp.dir == 1) {
                    tempCost += 600
                } else {
                    tempCost += 100
                }
                //checked 에서 넣으려는  인덱스의 값이  작으면 푸쉬 하지않는다.
                val location = Location(temp.i, temp.j - 1, tempCost, 2)

                if (checkArr(location, checked)) { // 비용이 더작으면 .
                    arrayList.add(location)
                    checked[location.i][location.j] = location.cost
                }


            }
            if (isRightGo(temp, board)) {
                var tempCost = temp.cost
                //cost계산
                if (temp.dir == 1) {
                    tempCost += 600
                } else {
                    tempCost += 100
                }

                val location = Location(temp.i, temp.j + 1, tempCost, 2)

                if (checkArr(location, checked)) { // 비용이 더작으면 .
                    arrayList.add(location)
                    checked[location.i][location.j] = location.cost
                }

            }
            if (isDownGo(temp, board)) {
                var tempCost = temp.cost
                //cost계산
                if (temp.dir == 2) {
                    tempCost += 600
                } else {
                    tempCost += 100
                }
                val location = Location(temp.i + 1, temp.j, tempCost, 1)

                if (checkArr(location, checked)) { // 비용이 더작으면 .
                    arrayList.add(location)
                    checked[location.i][location.j] = location.cost
                }
            }
            if (isUpGo(temp, board)) {
                var tempCost = temp.cost
                //cost계산
                if (temp.dir == 2) {
                    tempCost += 600
                } else {
                    tempCost += 100
                }
                val location = Location(temp.i - 1, temp.j, tempCost, 1)

                if (checkArr(location, checked)) { // 비용이 더작으면 .
                    arrayList.add(location)
                    checked[location.i][location.j] = location.cost
                }

            }
            arrayList.removeAt(0)
            if (arrayList.size == 0) {
                break;
            }

        }
        return (checked[checked.size - 1][checked.size - 1])
    }

}

private fun checkArr(location: Location, checked: Array<Array<Int>>): Boolean {
    if (checked[location.i][location.j] == 0) {
        return true
    } else return checked[location.i][location.j] >= location.cost

}

fun isRightGo(temp: Location, board: Array<IntArray>): Boolean {
    if (temp.j + 1 == board.size) {
        return false
    } else {
        if (board[temp.i][temp.j + 1] != 1) {
            return true
        }
        return false
    }
}

fun isLeftGo(temp: Location, board: Array<IntArray>): Boolean {
    if (temp.j - 1 == -1) {
        return false
    } else {
        if (board[temp.i][temp.j - 1] != 1) {
            return true
        }
        return false
    }


}

fun isUpGo(temp: Location, board: Array<IntArray>): Boolean {
    if (temp.i - 1 == -1) {
        return false
    } else {
        if (board[temp.i - 1][temp.j] != 1) {
            return true
        }
        return false
    }


}

fun isDownGo(temp: Location, board: Array<IntArray>): Boolean {
    if (temp.i + 1 == board.size) {
        return false
    } else {
        if (board[temp.i + 1][temp.j] != 1) {
            return true
        }
        return false
    }


}



/*fun makeRace(i:Int,j:Int,board: Array<IntArray>):String{

    if(isRightGo(i,j,board)){ //"R"
     return makeRace(i,j+1,board)
    }else if(isDownGo(i,j,board)){//"D"
        makeRace(i+1,j,board)
    }else{

    }
}
private fun isRightGo(i:Int,j:Int,board: Array<IntArray>):Boolean{
    return if(j+1>=board.size) false
    else board[i][j+1] != 1
}
private fun isDownGo(i:Int,j:Int,board: Array<IntArray>):Boolean{
    return if(i+1>=board.size) false
    else board[i+1][j] != 1
}*/
class Location(var i: Int, var j: Int, var cost: Int, var dir: Int)


fun main() {
   println(Solution().solution(arrayOf(intArrayOf(0, 0, 1, 0), intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 0, 1), intArrayOf(1, 0, 0, 0))))
}

