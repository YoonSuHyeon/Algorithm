package KaKao
fun openChatRoomSolution(record: Array<String>): Array<String> {
    var answer = ArrayList<String>()
    var userid= mutableMapOf<String,String>()

    for(r in record){
        val s=r.split(" ")
        if(s[0]=="Enter" || s[0] =="Change"){
            userid[s[1]] = s[2]
            //userid.put(s[1],s[2])
        }
    }
    for(i in 0 until record.size){
        when(record[i].split(" ")[0]){
            "Enter" ->{
                    println(record[i].split(" ")[1])
                    println(userid.get(record[i].split(" ")[1]))
                    answer.add(userid.get(record[i].split(" ")[1])+"님이 들어왔습니다.")
            }
            "Leave"->{
                answer.add(userid.get(record[i].split(" ")[1])+"님이 나갔습니다.")
            }

        }
    }
    return answer.toTypedArray()
}
fun main(){
    openChatRoomSolution(arrayOf("Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"))
}