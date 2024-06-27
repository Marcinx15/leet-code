package top_interview_150.array

fun main() {
    rotate4(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3)
    rotate4(intArrayOf(-1, -100, 3, 99), 2)
}

private fun rotate(nums: IntArray, k: Int) {
    val tempArr = IntArray(nums.size)
    for (i in nums.indices) tempArr[(i + k) % nums.size] = nums[i]
    for (i in nums.indices) nums[i] = tempArr[i]
}

fun rotate2(nums: IntArray, k: Int) {
    val rotate = k % nums.size
    val tempArr = nums.copyOfRange(nums.size - rotate, nums.size) + nums.copyOfRange(0, nums.size - rotate)
    for (i in nums.indices) nums[i] = tempArr[i]
    println(nums.toList())
}

fun rotate3(nums: IntArray, k: Int) {
    val rotateBy = k % nums.size
    repeat(rotateBy) {
        var current = nums[0]
        for (i in 0 until nums.lastIndex) {
            val temp = nums[(i + 1)]
            nums[i + 1] = current
            current = temp
        }
        nums[0] = current
    }
}

fun rotate4(nums: IntArray, k: Int) {
    val rotateBy = k % nums.size
    reverse(nums, 0, nums.lastIndex)
    reverse(nums, 0, rotateBy - 1)
    reverse(nums, rotateBy, nums.lastIndex)
    println(nums.toList())
}

fun reverse(arr: IntArray, startIndex: Int, endIndex: Int) {
    var i = startIndex
    var j = endIndex
    while(i < j) {
        swap(arr, i, j)
        i+= 1
        j -= 1
    }
}

private fun swap(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}
