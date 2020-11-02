package DFS_BFS
fun solution(n: Int): IntArray {
    var answer=ArrayList<Int>()
    val finish = n*(n+1)/2 //마지막 숫자.
    var temp = Array(n) {IntArray(n)}

    var status ="D"
    var i  =0
    var j =0
    var pos =1
    while(pos <=finish){
        temp[i][j] = pos

        if(status=="D"){
            if(i+1> n-1){
                status ="R"
                j++
                pos++
            }else{
                if(temp[i+1][j]==0){
                    i++
                    pos++
                }else{
                    status ="R"
                    j++
                    pos++
                }

            }
        }else if(status=="R"){
            if(j+1 >n-1){
                status= "U"
                i--
                j--
                pos++
            }else{
                if(temp[i][j+1]==0){
                    j++
                    pos++
                }else{
                    status= "U"
                    i--
                    j--
                    pos++
                }

            }
        }else{
            if(temp[i-1][j-1]==0){
                i--
                j--
                pos++
            }else{
                status="D"
                i++
                pos++
            }
        }

    }
    for(i in 0 until n){
        for(j in 0 .. i){
            answer.add(temp[i][j])
        }
    }
    
    return  answer.toIntArray()
}


fun main(){
   val tt= solution(5)
    tt.forEach { println(it) }
}