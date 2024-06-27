package top_interview_150.ranges

fun main() {
    println(summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7)))
    println(summaryRanges(intArrayOf(0, 2, 3, 4, 6, 8, 9)))
    println(summaryRanges(intArrayOf(2)))
    println(summaryRanges(intArrayOf()))
}

fun summaryRanges(nums: IntArray): List<String> {
    if (nums.size == 1) return listOf(nums[0].toString())

    var a = 0
    var b = 1
    val result = mutableListOf<String>()
    while (b <= nums.size) {
        if (b == nums.size || nums[b - 1] + 1 != nums[b]) {
            if (b - a == 1) result.add("${nums[a]}") else result.add("${nums[a]}->${nums[b - 1]}")
            a = b
        }
        b++
    }

    return result
}