package top_interview_150.array

fun main() {
    println(removeDuplicates(intArrayOf(1, 1, 1, 2, 2, 3)))
    println(removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)))
}

private fun removeDuplicates(nums: IntArray): Int {
    var uniqueValue = nums[0]
    var occurrences = 1
    var index = 1

    for (i in 1..nums.lastIndex) {
        if (nums[i] != uniqueValue) {
            nums[index] = nums[i]
            index += 1
            occurrences = 1
            uniqueValue = nums[i]
        } else if (occurrences == 1) {
            nums[index] = nums[i]
            occurrences += 1
            index += 1
        }
    }

    return index
}
