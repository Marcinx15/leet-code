package top_interview_150.hashmap

fun main() {
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val valueToIndex = mutableMapOf<Int, Int>()
    nums.forEachIndexed { index, value ->
        valueToIndex[target - value]?.let {return intArrayOf(it, index) } ?: valueToIndex.put(value, index)
    }
    return intArrayOf()
}