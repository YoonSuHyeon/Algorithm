package KaKao

import kotlin.math.abs

fun pressTheKeyPadSolution(numbers: IntArray, hand: String): String {
    var lpos = "9" //* 을 인덱스 9로취급
    var rpos = "11"// # 을 인덱스 11로 취급
    var answer = ArrayList<String>()
    numbers.map {
        if (it == 0) 11 //0은 10이 아닌 11로 한후 아래에서 -1을한다.
        else it
    }
            .forEach {
                when (it.toString()) {
                    "1", "4", "7" -> {
                        lpos = (it-1).toString()
                        answer.add("L")
                    }
                    "3", "6", "9" -> {
                        rpos = (it-1).toString()
                        answer.add("R")
                    }
                    "2", "5", "8","11" -> {
                        if (abs(lpos.toInt() / 3 - (it-1) / 3) + abs(lpos.toInt() % 3 - (it-1) % 3)
                                < abs(rpos.toInt() / 3 - (it-1) / 3) + abs(rpos.toInt() % 3 - (it-1) % 3)) {
                            lpos = (it-1).toString()
                            answer.add("L")
                        } else if (abs(lpos.toInt() / 3 - (it-1) / 3) + abs(lpos.toInt() % 3 - (it-1) % 3)
                                >abs(rpos.toInt() / 3 - (it-1) / 3) + abs(rpos.toInt() % 3 - (it-1) % 3)) {
                            rpos = (it-1).toString()
                            answer.add("R")
                        } else {
                            if (hand[0].toUpperCase().toString() == "L") {
                                lpos = (it-1).toString()
                            } else {
                                rpos = (it-1).toString()
                            }
                            answer.add(hand[0].toUpperCase().toString())
                        }
                    }
                }
            }
    return answer.joinToString("")
}

fun main(args: Array<String>) {
    println(pressTheKeyPadSolution(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right"))
}