package top_interview_150.array

fun main() {
    println(strStr3(haystack = "sadbutsad", needle = "sad"))
    println(strStr3(haystack = "butsad", needle = "sad"))
    println(strStr3(haystack = "leetcode", needle = "leeto"))
    println(strStr3("mississippi", "issip"))
    println(strStr3("ssssssa", "sad"))
}

fun strStr(haystack: String, needle: String): Int {
    var matched: Int
    haystack.indices.forEach { haystackIndex ->
        if (haystack.length - haystackIndex < needle.length) return -1
        matched = 0
        needle.forEach { needleChar ->
            if (haystack[haystackIndex + matched] == needleChar) matched++
            if (matched == needle.length) return haystackIndex
        }
    }
    return -1
}

fun strStr3(haystack: String, needle: String): Int {
    for (i in 0..haystack.length - needle.length) {
        for (j in 0..needle.length) {
            if (haystack[i + j] != needle[j]) break
            if (j == needle.length - 1) return i
        }
    }
    return -1
}

fun strStr2(haystack: String, needle: String): Int {
    for (i in 0..haystack.length - needle.length) {
        if (haystack.substring(i, i + needle.length) == needle) return i
    }
    return -1
}

/*
    mississippi
    issip
 */