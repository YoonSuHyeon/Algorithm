package KaKao
fun candidateKeySolution(relation: Array<Array<String>>): Int {
    var answer = 0
    var attributeIndex=relation[0].mapIndexed { index, s ->index}
            .toMutableList()

    for(i in attributeIndex.indices){
        val temp=relation.map { it[i] }
               .toSet()
                .size
        if(temp==relation.size){
            attributeIndex.remove(i)
            answer++
        }
    }
    return answer
}

fun main(){

    var temp= arrayOf(arrayOf("100","ryan","music","2"), arrayOf("200","apeach","math","2"),arrayOf("300","tube","computer","3"),
            arrayOf("400","con","computer","4"), arrayOf("500","muzi","music","3"), arrayOf("600","apeach","music","2"))
    candidateKeySolution(temp)
}