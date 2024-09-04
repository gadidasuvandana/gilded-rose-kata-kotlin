import kotlin.math.min

fun main() {
    val a = listOf(1,1,0,0,2,1)
//    val b=a.groupBy { it }.values.flatten()
    println(a.indexOf(8))
    println(a.last() == a.min())
    println(a.subList(2,a.size))
    val b = intArrayOf(3,5,67,3,22)
    b.forEachIndexed { index, i ->
//        b[index]= min(b.drop(i))
    }
    fun select(rightsideList:List<Int>): Pair<Int,Int>{
        val minele= rightsideList.min()
        val iminele = rightsideList.indexOf(minele)
        return Pair(minele,iminele)
    }
    fun selectsort(mylist: List<Int>) {
        val n= mylist.size
        mylist.forEachIndexed { index, ele ->
            val cur_min= ele
//            for()
        }
    }
    selectsort(listOf(5,4,3,2))
}