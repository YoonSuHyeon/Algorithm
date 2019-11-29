package Sort
fun h_IndexSolution(citations: IntArray): Int {
    var n =citations.size
    var h:Int
    var answer =0;
    for(i in 0 until citations.max()!!){
        h=citations.filter { it>=i }.count()
        if(i>h){
            break;
        }else{
            answer=i
        }
    }
    return answer
}
fun main(){
 println(h_IndexSolution(intArrayOf(2,2,2)))
}