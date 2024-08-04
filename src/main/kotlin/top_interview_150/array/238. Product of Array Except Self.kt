package top_interview_150.array

fun main() {
    println(productExceptSelf2(intArrayOf(1, 2, 3, 4)).toList())
    println(productExceptSelf2(intArrayOf(-1, 1, 0, -3, 3)).toList())
}

fun productExceptSelf(nums: IntArray): IntArray {
    val prefixProduct = IntArray(nums.size)
    val postfixProduct = IntArray(nums.size)

    prefixProduct[0] = 1
    for (index in 0 until nums.lastIndex) {
        prefixProduct[index + 1] = prefixProduct[index] * nums[index]
    }

    postfixProduct[postfixProduct.lastIndex] = 1
    for (index in nums.lastIndex downTo 1) {
        postfixProduct[index - 1] = postfixProduct[index] * nums[index]
    }

    val result = IntArray(nums.size)
    for (index in result.indices) {
        result[index] = prefixProduct[index] * postfixProduct[index]
    }

    return result
}

fun productExceptSelf2(nums: IntArray): IntArray {
    val result = IntArray(nums.size)

    result[0] = 1
    for (index in 0 until nums.lastIndex) {
        result[index + 1] = result[index] * nums[index]
    }

    var postfixProduct = 1
    for (index in nums.lastIndex downTo 1) {
        postfixProduct *= nums[index]
        result[index - 1] = postfixProduct * result[index - 1]
    }

    return result
}


/*
 [1,2,3,4]
 [1,1,2,6]
 */