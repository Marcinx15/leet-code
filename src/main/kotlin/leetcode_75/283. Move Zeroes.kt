package leetcode_75

fun main() {
    val test = intArrayOf(0,1,0,3,12)
    Solution283().moveZeroes(test)
    test.forEach { println(it) }
}

class Solution283 {
    fun moveZeroes(nums: IntArray): Unit {
        var start = nums.indexOfFirst { it == 0 }
        if (start == -1) return
        var end = start + 1
        while (end < nums.size) {
            if (nums[end] != 0) {
                nums[start] = nums[end]
                nums[end] = 0
                start++
            }
            end++
        }
    }

    /*
     [0,1,0,3,12]
     [1,0,0,3,12]
     [1,3,0,0,12]
     [1,3,12,0,0]


     [1,0,3,0,12]
     [1,3,12,0,0]

     [0,1,3,12,0]
     [1,0,3,12,0]
     [1,3,0,12,0]
     [1,3,12,0,0]

     */
}