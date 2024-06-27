package top_interview_150.sliding_window


fun main() {
    println(minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
    println(minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1)))
}

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var minLength = Int.MAX_VALUE
    var currentSum = 0
    var startIndex = 0
    for (endIndex in nums.indices) {
        currentSum += nums[endIndex]
        while (currentSum >= target) {
            minLength = minOf(minLength, endIndex - startIndex + 1)
            currentSum -= nums[startIndex]
            startIndex++
        }
    }
    return if (minLength == Int.MAX_VALUE) 0 else minLength
}
