package top_interview_150.array


fun main() {
    println(removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
}

private fun removeDuplicates(nums: IntArray): Int {
    var lastUniqueValue = nums[0]
    var nextValueIndex = 1;
    for (i in 1..nums.lastIndex) {
        if (nums[i] != lastUniqueValue) {
            lastUniqueValue = nums[i]
            nums[nextValueIndex] = lastUniqueValue
            nextValueIndex++
        }
    }

    return nextValueIndex
}

fun removeDuplicates2(nums: List<Int>): List<Int> =
    nums.fold(listOf(nums.first())) { acc, elem ->
        if (acc.last() != elem) acc + elem
        else acc
    }