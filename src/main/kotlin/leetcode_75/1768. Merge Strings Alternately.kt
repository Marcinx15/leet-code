package leetcode_75.arrays_and_strings

import kotlin.math.min

fun main() {
    val solution = Solution1768()
    val testCases = listOf(
        "abc" to "pqr",
        "ab" to "pqrs",
        "abcd" to "pq"
    )

    testCases.forEach {
        println(solution.mergeAlternately(it.first, it.second))
    }
}

class Solution1768 {
    fun mergeAlternately(word1: String, word2: String): String {
        val builder = StringBuilder()
        val minLength = min(word1.length, word2.length)
        (0 until minLength).forEach { idx ->
            builder.append(word1[idx])
            builder.append(word2[idx])
        }

        if (word1.length > word2.length) builder.append(word1.substring(minLength))
        else if(word1.length < word2.length) builder.append(word2.substring(minLength))

        return builder.toString()
    }
}