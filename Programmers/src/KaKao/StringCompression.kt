package KaKao
fun stringCompressionSolution(s: String): Int {
    var answer = 0
    var temp =""
    var prestring :String=""
    var countnum =1

    for(i in 1..s.length/2){
        for(j in 0 until s.length step i){
            if(j==0){
                prestring =s.substring(j until  j+i)
            }else {
                if(j+i>s.length)
            }


        }
        println(temp)
        if(temp.length<answer)answer=temp.length
        prestring=""
        temp=""
        countnum=1

    }
    return answer
}
fun main(){
    stringCompressionSolution("aabbaccc")
}
