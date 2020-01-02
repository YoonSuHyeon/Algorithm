package Level2

fun makePrimeSolution(nums: IntArray): Int {
    var answer = 0
    val temp  = ArrayList<Int>()
    var sum=0
    for(i in 0..nums.size-3){
        for(j in i+1..nums.size-2){
            for(k in j+1..nums.size-1){
                temp.add(nums[i]+nums[j]+nums[k])
                //println("${nums[i]} ${nums[j]} ${nums[k]}   ")
            }
        }
    }
    if(temp.size==0){
        return answer
    }else{
        var temp1 = temp.toIntArray()
        var test =true //소수
        for(i in temp1.indices){
            for(j in 2 until temp1[i]){
                if(temp1[i]%j==0){
                    test=false
                    break;
                }
            }
            if(test) answer++
            test=true
        }
    }
    //println(answer)
    return answer
}

fun main(){
    makePrimeSolution(intArrayOf(1,2,3,4))
}