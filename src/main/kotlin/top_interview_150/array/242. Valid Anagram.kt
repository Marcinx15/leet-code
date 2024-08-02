package top_interview_150.array

fun main() {
    println(isAnagram(s = "anagram", t = "nagaram"))
    println(isAnagram(s = "anagraam", t = "nagaram"))
    println(isAnagram(s = "rat", t = "car"))
}

fun isAnagram(s: String, t: String): Boolean {
    if (t.length != s.length) return false

    val characters: MutableMap<Char, Int> = mutableMapOf()
    s.forEach { characters.merge(it, 1) { old, _ -> old + 1 } }
    t.forEach {
        val occurrences = characters[it]
        if (occurrences == null || occurrences == 0) return false
        else characters[it] = occurrences - 1
    }

    return characters.all { it.value == 0 }
}