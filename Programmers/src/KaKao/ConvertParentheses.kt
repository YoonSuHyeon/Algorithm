package KaKao

fun ConvertParenthesesSolution(p: String): String {
    var answer = ""
    var temp=""
    if(p=="") return ""
    var u=""
    var v=""
    //UV로 나누기 위함
    var leftC=0//  ( 개수
    var rightC=0//  ) 개수
    for(i in p){
        if(i=='(')
            leftC++
        else
            rightC++
        if(leftC==rightC) break;
    }
    println(rightC)
    println(leftC)
    if(rightC+leftC==p.length){
        u=p
        v=""
    }else {
        u = p.substring(0..(leftC + rightC - 1))
        v = p.substring((leftC + rightC) until p.length)
    }
    if(isCorrectString(u)){
        answer=answer+u+ConvertParenthesesSolution(v)
        return answer
    }else{
        temp+="("+ ConvertParenthesesSolution(v)
        temp+=")"
        //첫번째 마지막문자 제거후 나머지 문자열 방향 뒤집는다.
        val temp2=u.filterIndexed { index, c ->index!=0&&index!=u.length-1  }
                .map { if(it=='(')  ')'
                else '('
                }
                .joinToString("")
        println(temp2)
        temp+=temp2
        return temp
    }
}
fun isCorrectString(s:String):Boolean{
    //s가 올바른 문자열이면 True
    var temp3 =ArrayList<Char>()
    var leftC =0
    var rightC =0


    for(i in s){
        if(i=='(') leftC++
        else rightC++
        if(leftC<rightC) {
            return false
        }else if(rightC>0&&leftC>0){
            rightC--
            leftC--
        }
    }
    return true

}

fun main(){
   println( ConvertParenthesesSolution("()))((()"))
}