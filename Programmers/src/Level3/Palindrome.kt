package Level3
fun palindromeSolution(s: String): Int {
    var answer = 0
    for (i in 3 until s.length){ //3문자로 부터 가능 하기 때문에 3부터시작
        for(j in s.indices){
            if(j+i>s.length-1)break;

        }
    }
    return answer
}
fun main(){
    palindromeSolution("abcdcba")
}
