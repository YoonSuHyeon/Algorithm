package Level1

fun stringhandlingBasicssolution(s: String): Boolean {
    var count =  s.count { it=='0'||it=='1'||it=='2'||it=='3'||it=='4'||it=='5'||it=='6'||it=='7'||it=='8'||it=='9' }
    if(count==s.length) return true
    else return false
}
fun main(){
   println( stringhandlingBasicssolution("0000"))
}