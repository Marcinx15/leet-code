package top_interview_150.two_pointers

fun main() {
    println(twoSum(numbers = intArrayOf(2,7,11,15), target = 9).toList())
    println(twoSum(numbers = intArrayOf(2, 3, 4), target = 6).toList())
    println(twoSum(numbers = intArrayOf(-1, 0), target = -1).toList())
}

fun twoSum(numbers: IntArray, target: Int): IntArray {
    var (left, right) = Pair(0, numbers.lastIndex)
    while (left < right) {
        val sum = numbers[left] + numbers[right]
        when {
            sum == target -> return intArrayOf(left + 1, right + 1)
            sum < target -> left++
            else -> right--
        }
    }
    return intArrayOf()
}

/*

[2,7,11,12,15] target = 18
[a,b,c,d,e,f,g,h,i,j,k,l,m,n]

    c + l > target

    b + m < target || b + n < target => b + l < target


 */
