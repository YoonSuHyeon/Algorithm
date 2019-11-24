package Level1
fun hideCellPhoneNumberSolution(phone_number: String): String {

    return phone_number.mapIndexed { index, c ->
        if(phone_number.length-4>index) "*"
        else c.toString()

    }
            .joinToString ("")



}
fun main(){
    hideCellPhoneNumberSolution("01033334444")
}