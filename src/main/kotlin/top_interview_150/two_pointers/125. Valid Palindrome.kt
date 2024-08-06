package top_interview_150.two_pointers

fun main() {
    println(isPalindrome("A man, a plan, a canal: Panama"))
    println(isPalindrome("race a car"))
    println(isPalindrome(" "))
}

fun isPalindrome(s: String): Boolean {
    val processed = s.lowercase().filter { it.isLetterOrDigit() }
    var (startIndex, endIndex) = Pair(0, processed.length - 1)
    while (startIndex < endIndex) {
        if (processed[startIndex] != processed[endIndex]) return false
        startIndex++
        endIndex--
    }
    return true
}