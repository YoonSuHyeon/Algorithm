package KaKao
fun stringCompressionSolution(s: String): Int {
    var answer = s.length
    var temp =""
    var prestring :String=""
    var countnum =1
    for(i in 1..s.length/2){//  길이/2 만 검사를 하면 된다.
        for(j in 0 until s.length step i){
            if(j==0){
                prestring=s.substring(j until j+i)
            }else{
                if(j+i>s.length){//다음이 마지막인데 길이보다 클때
                    temp = if(countnum==1){
                        temp+prestring+s.substring(j)
                    }else{
                        temp+countnum.toString()+prestring+s.substring(j)
                    }
                }else if(j+i==s.length){//다음이 마지막일때
                    temp = if(prestring==s.substring(j until j+i)){
                        countnum++
                        temp+countnum.toString()+prestring
                    }else{
                        if(countnum==1){
                            temp+prestring+s.substring(j)
                        }else{
                            temp+countnum.toString()+prestring+s.substring(j)
                        }
                    }
                }else{
                    if(prestring==s.substring(j until j+i)){
                        countnum++
                    }else{
                        if(countnum==1){
                            temp += prestring
                            prestring=s.substring(j until j+i)
                            countnum=1
                        }else{
                            temp= temp+countnum.toString()+prestring
                            prestring=s.substring(j until j+i)
                            countnum=1
                        }

                    }
                }

            }
        }
      if(answer>temp.length)answer=temp.length
        countnum=1
        temp=""
        prestring=""
    }



    return answer
}
fun main(){
    stringCompressionSolution("bbbbaccc")
}
