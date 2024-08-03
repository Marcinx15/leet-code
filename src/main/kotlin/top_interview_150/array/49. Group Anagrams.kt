package top_interview_150.array

fun main() {
    println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
    println(groupAnagrams(arrayOf("")))
    println(groupAnagrams(arrayOf("a")))
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    return strs.groupBy { str -> str.groupBy { it }.mapValues { entry -> entry.value.size } }.values.toList()
}
