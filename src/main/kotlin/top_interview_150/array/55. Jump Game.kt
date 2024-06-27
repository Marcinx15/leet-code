package top_interview_150.array

fun main() {
    println(canJump(intArrayOf(2, 3, 1, 1, 4)))
    println(canJump(intArrayOf(3, 2, 1, 0, 4)))
}

fun canJump3(nums: IntArray): Boolean {
    nums[nums.lastIndex] = -1
    nums.indices.reversed().drop(1).forEach { index ->
        if ((1..nums[index]).any { nums[index + it] == -1 }) nums[index] = -1
    }
    return nums[0] == -1
}

fun canJump2(nums: IntArray): Boolean {
    val lastIndex = nums.lastIndex
    fun helper(index: Int): Boolean =
        (nums[index] until 1).any {
            if (index + it == lastIndex) true
            else (helper(index + it))
        }

    return if (nums.size == 1) true else helper(0)
}

fun canJump(nums: IntArray): Boolean {
    var goal = nums.lastIndex
    for (i in nums.lastIndex - 1 downTo 0) {
        if (i + nums[i] >= goal) goal = i
    }
    return goal == 0
}

//fun canJump4(nums: IntArray): Boolean {
//    val dp = IntArray(nums.size)
//    dp.fill(-1)
//    return helper(0, nums, dp)
//}
//
//fun helper(index: Int, nums: IntArray, dp: IntArray): Boolean {
//    if (index >= nums.lastIndex) return true
//
//    if (nums[index] == 0) {
//        dp[index] = 0
//        return false
//    }
//
//    if (dp[index] != -1) {
//        return dp[index] == 1
//    }
//
//    for (i in 1..nums[index]) {
//        if (helper(index + i, nums, dp)) {
//            dp[index] = 1
//            return true
//        }
//    }
//
//    dp[index] = 0
//    return false
//}