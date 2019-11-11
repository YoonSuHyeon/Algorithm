package Hash


    fun  BestAlbumsolution(genres: Array<String>, plays: IntArray): IntArray {
        return genres.indices.groupBy { genres[it] }
                .toList()
                .sortedByDescending { it.second.sumBy { plays[it] } }
                .map { it.second.sortedByDescending { plays[it] }.take(2) }
                .flatten()
                .toIntArray()
    }
fun main(){
    val genres = arrayOf("classic", "pop", "classic", "classic", "pop")
    var plays = intArrayOf(500, 600, 150, 800, 2500)
    BestAlbumsolution(genres,plays).forEach { println(it) }
}