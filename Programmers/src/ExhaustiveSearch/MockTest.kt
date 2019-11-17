package ExhaustiveSearch
fun mockTestsolution(answers: IntArray): IntArray {
    var answer = intArrayOf(0,0,0)
    //반복되는 패턴으로 초기화 해준다.
    val one = intArrayOf(1,2,3,4,5)
    val two = intArrayOf(2,1,2,3,2,4,2,5)
    val three = intArrayOf(3,3,1,1,2,2,4,4,5,5)
    //문제 채점
    answer[0] =answers.filterIndexed { index, it -> one[index%one.size]==it  }
            .count()
    answer[1]=answers.filterIndexed { index, it -> two[index%two.size]==it  }
            .count()
    answer[2]=answers.filterIndexed { index, it -> three[index%three.size]==it  }
            .count()
    //맞은개수로 비교후 answer 에 가장 큰사람들만 자기의 인덱스+1을 해주고 다른 사람은 -1로 바꿔준다.
    val max =answer.max()
    answer.filterIndexed { index, it ->
         if (it >= max!!) {
            answer[index] = index + 1
            true
          } else {
             answer[index] = -1
             true
          }
  }

  return    answer.filter { it!=-1 }
            .toIntArray()



}
fun main(){
    val answers= intArrayOf(1,2,3,4,5)
     mockTestsolution(answers).forEach { println(it) }
}