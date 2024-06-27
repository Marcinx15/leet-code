package top_interview_150.hashmap

fun main() {
    listOf(
        canConstruct(ransomNote = "a", magazine = "b"),
        canConstruct(ransomNote = "aa", magazine = "ab"),
        canConstruct(ransomNote = "aa", magazine = "aab")
    ).forEach { println(it) }
}

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val magazineLetters: MutableMap<Char, Int> = magazine.groupBy { it }.mapValues { it.value.size }.toMutableMap()
    ransomNote.forEach {
        val occ = magazineLetters[it] ?: 0
        if (occ == 0) return false
        magazineLetters[it] = occ - 1
    }
    return true
}