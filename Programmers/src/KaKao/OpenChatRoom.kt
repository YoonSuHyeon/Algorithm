package KaKao
fun openChatRoomSolution(record: Array<String>): Array<String> {
    var answer = ArrayList<String>()
    var userid= mutableMapOf<String,String>()

    for(i in 0 until record.size){
        when(record[i].split(" ")[0]){
            "Enter" ->{
                if(userid.get(record[i].split(" ")[1])==record[i].split(" ")[2]){
                    userid.put(record[i].split(" ")[1],record[i].split(" ")[2])
                    answer.add(userid.get(record[i].split(" ")[1])+"님이 들어왔습니다.")
                }else{
                    for(i in 0 until answer.size){
                        if(answer[i].contains(userid.get(record[i].split(" ")[1]).toString()))
                            println(userid.get(record[i].split(" ")[1]).toString())
                            answer[i]=answer[i].replace(userid.get(record[i].split(" ")[1]).toString(),record[i].split(" ")[2])
                    }
                    userid.put(record[i].split(" ")[1],record[i].split(" ")[2])
                    answer.add(userid.get(record[i].split(" ")[1])+"님이 들어왔습니다.")
                }




            }
            "Leave"->{
                answer.add(userid.get(record[i].split(" ")[1])+"님이 나갔습니다.")
            }
            "Change"->{
                //바꿔주고
                userid.put(record[i].split(" ")[1],record[i].split(" ")[2])
            }
        }
    }

    println(answer[2].replace("Muzi","q"))
    println(answer)
    return record
}
fun main(){
    openChatRoomSolution(arrayOf("Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"))
}