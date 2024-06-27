package top_interview_150.array

fun main() {
    val nums = intArrayOf(3,2,2,3)
    val nums2 = intArrayOf(0,1,2,2,3,0,4,2)
    val k = removeElement(nums2, 2)
    println("k=$k, nums=${nums2.toList()}")
}

fun removeElement(nums: IntArray, value: Int): Int {
    var k = nums.size
    var i = 0
    while (i < k) {
        if (nums[i] == value) {
            k--
            swap(nums, i, k)
        } else i++
    }
    return k
}

private fun swap(array: IntArray, index1: Int, index2: Int) {
    val temp = array[index1]
    array[index1] = array[index2]
    array[index2] = temp
}