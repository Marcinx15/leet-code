package leetcode_75

fun main() {
    val solution = Solution643()
    println(solution.findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4))
}

class Solution643 {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var maxSum = (0 until k).sumOf { nums[it] }
        var currentSum = maxSum
        var firstElementIndex = 0
        var nextElementIndex = k
        while (nextElementIndex < nums.size) {
            currentSum = currentSum - nums[firstElementIndex] + nums[nextElementIndex]
            if (currentSum > maxSum) maxSum = currentSum
            firstElementIndex++
            nextElementIndex++
        }
        return maxSum / k.toDouble()
    }
}