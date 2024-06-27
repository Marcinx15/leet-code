package top_interview_150.array

fun main() {
    println(longestCommonPrefix3(arrayOf("flower", "flow", "flight")))
    println(longestCommonPrefix3(arrayOf("dog", "racecar", "car")))
}

fun longestCommonPrefix(strs: Array<String>): String {
    var commonPrefix: String = strs[0]
    for (str in strs.drop(1)) {
        var i = -1
        commonPrefix = commonPrefix.takeWhile {
            i += 1
            i < str.length && it == str[i]
        }
    }
    return commonPrefix
}

fun longestCommonPrefix2(strs: Array<String>): String {
    fun helper(arr: Array<String>, commonPrefix: String): String = if (arr.isEmpty()) commonPrefix
    else {
        val head = arr.first()
        val newPrefixSize = commonPrefix.zip(head).takeWhile { it.first == it.second }.size
        helper(arr.copyOfRange(1, arr.size), commonPrefix.take(newPrefixSize))
    }

    return helper(strs, strs.first())
}

fun longestCommonPrefix3(strs: Array<String>): String = StringBuilder().apply {
    strs.minBy { it.length }.forEachIndexed { i, c ->
        if (strs.all { it[i] == c }) append(c)
        else return@apply
    }
}.toString()