package top_interview_150.hashmap

fun main() {
    listOf(
        groupAnagrams(strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")),
        groupAnagrams(strs = arrayOf("")),
        groupAnagrams(strs = arrayOf("a")),
    ).forEach { println(it) }
}

fun groupAnagramsv1(strs: Array<String>): List<List<String>> {
    val charOccurrences = strs.toList().map { word ->
        word.groupBy { it }.mapValues { it.value.size }
    }
    val anagramIndices = charOccurrences.withIndex().groupBy({ it.value }, { it.index })
    return anagramIndices.values.map { it.map { index -> strs[index] } }
}

fun groupAnagrams(strs: Array<String>): List<List<String>> =
    strs.groupBy { it.toCharArray().sorted() }.values.toList()