package top_interview_150.array

import java.util.Stack

fun main() {
    reverseWords2("the sky is blue").let { println(it) }
    reverseWords2("  hello world  ").let { println(it) }
    reverseWords2("a good   example").let { println(it) }
}

fun reverseWords(s: String): String {
    val stack: Stack<String> = Stack()
    val wordBuilder = StringBuilder()
    var previousWasSpace = true

    s.forEach {
        if (it != ' ') {
            wordBuilder.append(it)
            previousWasSpace = false
        } else if (!previousWasSpace) {
            stack.push(wordBuilder.toString())
            wordBuilder.clear()
            previousWasSpace = true
        }
    }

    if (wordBuilder.isNotEmpty()) stack.push(wordBuilder.toString())

    wordBuilder.clear()
    while (!stack.isEmpty()) {
        wordBuilder.append(stack.pop())
        if (!stack.isEmpty()) wordBuilder.append(" ")
    }

    return wordBuilder.toString()
}

fun reverseWords2(s: String): String {
    val reversedWords = ArrayDeque<String>()

    var startIndex = 0
    var endIndex = 0
    while (startIndex < s.length) {
        while (startIndex < s.length && s[startIndex] == ' ') startIndex++
        if (startIndex == s.length) break

        endIndex = startIndex + 1
        while (endIndex < s.length && s[endIndex] != ' ') endIndex++

        reversedWords.addFirst(s.substring(startIndex, endIndex))
        startIndex = endIndex
    }

    return reversedWords.joinToString(separator = " ")
}

/*

    "  hello world  "

 */