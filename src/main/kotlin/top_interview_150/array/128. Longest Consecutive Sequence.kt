package top_interview_150.array

import kotlin.math.max

fun main() {
    println(longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
    println(longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
}

fun longestConsecutive(nums: IntArray): Int {
    val numsSet = nums.toSet()
    var maxLcs = 0
    numsSet.forEach {
        if ((it - 1) !in numsSet) {
            var length = 1
            while ((it + length) in numsSet) length++
            maxLcs = max(maxLcs, length)
        }
    }
    return maxLcs
}


/*
   [100,4,200,1,3,2,5]
    [1,2,3,4,5]

    1,2,3,4,5
    2,3,4,5



   100 -> 1
   200 -> 1
   1 -> 5

 */