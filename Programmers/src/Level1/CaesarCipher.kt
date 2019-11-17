package Level1

fun caesarCipherSolution(s: String, n: Int): String {

    var temp = s.toCharArray()
            .map{

                if(it <= 'Z')
                {
                    if(it == ' '){
                        ' '
                    }else if(it+n > 'Z'){//대문자 이지만 Z를 넘은경우
                        it+n-90+64
                    }else{
                        it+n
                    }
                }
                else {
                    if(it+n >'z'){
                        it+n-122+96
                    }else{
                        it+n
                    }
                }
            }
            .toCharArray()
    return String(temp)
}
fun main(){
    caesarCipherSolution("a B z",4)

}