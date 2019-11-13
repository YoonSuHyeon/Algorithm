package Level1

fun stringhandlingBasicssolution(s: String): Boolean {
    var count = s.count{it.isDigit()}
    if(count==s.length && (s.length == 4||s.length ==6)) return true
    else return false
}

fun main(){
   println( stringhandlingBasicssolution("0000"))
}