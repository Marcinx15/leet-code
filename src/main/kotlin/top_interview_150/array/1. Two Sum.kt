package top_interview_150.array

fun main() {
    println(twoSum(nums = intArrayOf(2, 7, 11, 15), target = 9).toList())
    println(twoSum(nums = intArrayOf(3, 2, 4), target = 6).toList())
    println(twoSum(nums = intArrayOf(3, 3), target = 6).toList())
}



fun twoSum(nums: IntArray, target: Int): IntArray {
    val valueToIndex: MutableMap<Int, Int> = mutableMapOf()
    nums.forEachIndexed { index, value ->
        val otherIndex = valueToIndex[target - value]
        otherIndex?.let { return intArrayOf(otherIndex, index) }
        valueToIndex[value] = index
    }
    return intArrayOf()
}