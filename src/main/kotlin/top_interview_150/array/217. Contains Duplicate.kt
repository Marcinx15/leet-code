package top_interview_150.array

fun main() {
    println(containsDuplicate(intArrayOf(1,2,3,1)))
    println(containsDuplicate(intArrayOf(1,2,3,4)))
    println(containsDuplicate(intArrayOf(1,1,1,3,3,4,3,2,4,2)))
}

fun containsDuplicate(nums: IntArray): Boolean {
    val numsSet: MutableSet<Int> = mutableSetOf()
    nums.forEach {
        if (numsSet.contains(it)) return true
        else numsSet.add(it)
    }
    return false
}