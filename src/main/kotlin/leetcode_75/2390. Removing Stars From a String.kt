package leetcode_75

import java.util.Stack

fun main() {
    println(removeStars("leet**cod*e"))
    println(removeStars("erase*****"))
}

fun removeStars(s: String): String {
    val result = Stack<Char>()
    s.forEach {
        if (it == '*') result.pop()
        else result.push(it)
    }
    return result.joinToString(separator = "")
}