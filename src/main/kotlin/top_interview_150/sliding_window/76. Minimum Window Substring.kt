package top_interview_150.sliding_window

fun main() {
    println(minWindow(s = "a", t = "a"))
}

fun minWindow(s: String, t: String): String {
    val charCount = t.groupBy { it }
        .mapValues { it.value.size }
        .toMutableMap()
    var remainingCharCount = t.length
    var startIndex = 0
    var minLeftIndex = 0
    var minRightIndex = Int.MAX_VALUE

    for (endIndex in s.indices) {
        charCount.computeIfPresent(s[endIndex]) { _, v ->
            if (v > 0) remainingCharCount--
            v - 1
        }
        while (remainingCharCount == 0) {
            if (endIndex - startIndex < minRightIndex - minLeftIndex) {
                minLeftIndex = startIndex
                minRightIndex = endIndex
            }
            charCount.computeIfPresent(s[startIndex]) { _, v ->
                if (v >= 0) remainingCharCount++
                v + 1
            }
            startIndex++
        }
    }

    return if (minRightIndex != Int.MAX_VALUE) s.substring(minLeftIndex, minRightIndex + 1) else ""
}