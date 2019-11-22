package Level1
fun collatzConjectureSolution(num: Int): Int {
    var temp:Long=num.toLong()
    var answer = 0
    for(i in 0 until 500){
        if(temp==1.toLong())return answer
        if (temp%2==0.toLong()){
            temp /= 2
            answer++
        }
        else {
            temp=temp*3+1
            answer++
        }
        if(temp==1.toLong()) {
            println(temp)
            return answer
        }

    }
   return -1
}
fun main(){
    println(collatzConjectureSolution(1))
}