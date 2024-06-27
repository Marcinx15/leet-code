package top_interview_150.two_pointers

fun main() {
    println(isPalindrome("A man, a plan, a canal: Panama"))
    println(isPalindrome("race a car"))
    println(isPalindrome(" "))
}

fun isPalindrome(s: String): Boolean {
    val toCheck = s.filter { it.isLetterOrDigit() }.toLowerCase()
    var i = 0
    var j = toCheck.lastIndex
    while (i < j) {
        if (toCheck[i] != toCheck[j]) return false
        i++
        j--
    }
    return true
}