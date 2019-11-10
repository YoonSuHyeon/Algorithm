package Hash
fun solution(clothes: Array<Array<String>>): Int {

    var temp = mutableMapOf<String,Int>()

    for(i in clothes.indices){
        if(temp.containsKey(clothes[i][1]))
            temp.replace(clothes[i][1], temp.getValue(clothes[i][1])+1)
        else
            temp.put(clothes[i][1],1)
    }
    var answer =1;
    for(value in temp.values){
        answer=answer*(value+1)
    }
    answer -=1
    return answer
}
fun main(){
    val ccc = Array<String>(2) {
        when(it){
            0->"yellow_hat"
            1->"headgear"
            else->"null"
        }}
    val ccb = Array<String>(2) {
        when(it){
            0->"blue_sunglasses"
            1->"eyewear"
            else->"null"
        }
    }
    val ccd = Array<String>(2){
        when(it){
            0->"green_turban"
            1->"headgear"
            else->"null"
        }
    }
    var clothes : Array<Array<String>> = Array(3,init={
        when(it){
            0-> ccc
            1-> ccb
            2-> ccd
            else-> ccc
        }
    })
    println(solution(clothes))
}