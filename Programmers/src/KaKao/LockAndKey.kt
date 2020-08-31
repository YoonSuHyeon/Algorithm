package KaKao

import java.util.*

fun LockAndKeySolution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
    var board = initArr(key.size, lock.size,lock)
    /**
     * 회전한 총 4경우
     * **/
   var rotateList=ArrayList<Array<IntArray>>()
    rotateList.add(key)
    for(i in 0..2){
        rotateList.add(rotateKey(rotateList[i]))
    }

    for(i in 0 until board.size-2){
        for(j in 0 until board.size-2){
           if( checkLock(rotateList,board, i, j,lock)) return true
        }
    }

    return false
}

fun initArr(keySize: Int, lockSize: Int, lock: Array<IntArray>): Array<IntArray> {
    val size = (keySize - 1) * 2 + lockSize
    var board = Array(size, init = { IntArray(size) })
    for(i in 0 until lockSize){
        for(j in 0 until lockSize){
            board[i+keySize-1][j+keySize-1]=lock[i][j]
        }
    }
    return board
}

fun checkLock(keyList: ArrayList<Array<IntArray>>, board: Array<IntArray>,i:Int,j:Int,lock:Array<IntArray>): Boolean {


//    temp.forEach { it.forEach { i->print(i) }
//    println()}
//    println("--------------")
//    board.forEach { it.forEach { i->print(i) }
//        println()}
//    println("--------------")
    var boolean=true
    for(key in keyList){
        var temp = initArr(keyList[0].size, lock.size,lock)

        for(k in 0 until key.size){
            for(l in 0 until key.size){
                temp[i+k][j+l]+=key[k][l]
            }
        }
        for(k in 0 until lock.size){
            for(l in 0 until lock.size){
                if(temp[k+key.size-1][l+key.size-1]!=1){
                    boolean = false
                }

            }
            if(!boolean) break;
        }
        if(boolean) return true
        boolean=true
        temp =board.copyOf()
    }

    return false
}

fun rotateKey(key: Array<IntArray>): Array<IntArray> {
    var temp = Array(key.size, init = { IntArray(key.size) })
    for (i in 0 until key.size) {
        for (j in 0 until key.size) {
            temp[i][j] = key[key.size - 1 - j][i]
        }
    }
    return temp
}


fun main() {
    println(LockAndKeySolution(arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 0, 0), intArrayOf(0, 1, 1))
            , arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1))))
}