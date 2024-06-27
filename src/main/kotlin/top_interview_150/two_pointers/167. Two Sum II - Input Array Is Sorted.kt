package top_interview_150.two_pointers

fun main() {
    println(twoSum(numbers = intArrayOf(2,7,11,15), target = 9).toList())
}

fun twoSum(numbers: IntArray, target: Int): IntArray {
    var startIndex = 0
    var endIndex = numbers.lastIndex
    while(true) {
        val sum = numbers[startIndex] + numbers[endIndex]
        when {
            sum < target -> startIndex++
            sum > target -> endIndex--
            else -> return intArrayOf(startIndex + 1, endIndex + 1)
        }
    }
}