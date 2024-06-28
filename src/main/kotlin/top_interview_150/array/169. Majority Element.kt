package top_interview_150.array

fun main() {
    val nums = intArrayOf(2, 4, 3, 4, 2, 4)
    val nums2 = intArrayOf(1, 1, 1, 2, 2, 2, 1)
    val nums3 = intArrayOf(2,2,2,7,7,2,3)

    majorityElement(nums).also { println(it) }
    majorityElement(nums2).also { println(it) }
    majorityElement(nums3).also { println(it) }
}

fun majorityElement(nums: IntArray): Int {
    var candidate = nums[0]
    var count = 0
    for (i in nums) {
        if (count == 0) candidate = i

        if (i == candidate) count++
        else count--
    }
    return candidate
}