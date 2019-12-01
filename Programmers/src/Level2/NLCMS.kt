package Level2

fun nLCOMSSolution(arr: IntArray): Int {
    var answer = arr.max()
    var i =2
    while(true){
        var temp =arr.filter {answer!!%it==0 }.count()
        if(temp==arr.size){
            return answer!!
        }
        else{
            answer = arr.max()!!*i
            i++
        }
    }

}
fun main(){
    println(nLCOMSSolution(intArrayOf(2,6,8,14)))
}