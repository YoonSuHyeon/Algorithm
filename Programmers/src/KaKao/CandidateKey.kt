package KaKao

import java.awt.event.ComponentAdapter

fun candidateKeySolution(relation: Array<Array<String>>): Int {
    var answer = 0
    var attributeIndex=relation[0].mapIndexed { index, s ->index.toString()}
            .joinToString("")
    var temp = setOf<String>()
    for(i in relation[0].indices){ // 크기가 1,2,3,4.....
        for(j in relation[0].indices){//처음부터 0,1,2,3....
            for(k in j+i..relation[0].size){

            }
        }
    }


    return answer
}

fun main(){

    var temp= arrayOf(arrayOf("100","ryan","music","2"), arrayOf("200","apeach","math","2"),arrayOf("300","tube","computer","3"),
            arrayOf("400","con","computer","4"), arrayOf("500","muzi","music","3"), arrayOf("600","apeach","music","2"))
    candidateKeySolution(temp)
}