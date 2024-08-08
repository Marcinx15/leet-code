package top_interview_150.two_pointers

fun main() {
    println(threeSum2(intArrayOf(-1, 0, 1, 2, -1, -4)))
    println(threeSum2(intArrayOf(0, 1, 1)))
    println(threeSum2(intArrayOf(0, 0, 0)))
}

fun threeSum(nums: IntArray): List<List<Int>> {
    val result = hashSetOf<List<Int>>()
    nums.sort()

    for (i in 0 until nums.size - 2) {
        val target = -nums[i]
        var (left, right) = Pair(i + 1, nums.lastIndex)
        while (left < right) {
            val sum = nums[left] + nums[right]
            when {
                sum < target -> left++
                sum > target -> right--
                else -> {
                    result.add(listOf(nums[i], nums[left], nums[right]))
                    left++
                    right--
                }
            }
        }
    }

    return result.toList()
}

fun threeSum2(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()

    for (index in 0 until nums.size - 2) {
        if (index > 0 && nums[index - 1] == nums[index]) continue

        val target = -nums[index]
        var (left, right) = Pair(index + 1, nums.lastIndex)
        while (left < right) {
            val sum = nums[left] + nums[right]
            when {
                sum < target -> left++
                sum > target -> right--
                else -> {
                    result.add(listOf(nums[index], nums[left], nums[right]))
                    left++
                    while (nums[left] == nums[left - 1] && left < right) left++
                    right--
                }
            }
        }
    }

    return result
}
