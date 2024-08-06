package top_interview_150.array

import java.util.Stack

fun main() {
    reverseWords("the sky is blue").let { println(it) }
    reverseWords("  hello world  ").let { println(it) }
    reverseWords("a good   example").let { println(it) }
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

/*



 */