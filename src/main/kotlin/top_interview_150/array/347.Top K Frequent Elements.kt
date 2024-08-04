package top_interview_150.array

fun main() {
    println(topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2).toList())
    println(topKFrequent(intArrayOf(1), 1).toList())
    println(topKFrequent(intArrayOf(1, 1, 1, 2, 3, 3), 2).toList())
}

fun topKFrequent3(nums: IntArray, k: Int): IntArray {
    val numberFrequency: MutableMap<Int, Int> = mutableMapOf()
    nums.forEach {
        numberFrequency.merge(it, 1) { old, _ -> old + 1 }
    }
    val result: MutableList<Int> = mutableListOf()
    repeat(k) {
        val maxFrequencyKey = numberFrequency.maxBy { it.value }.key
        result.add(maxFrequencyKey)
        numberFrequency.remove(maxFrequencyKey)
    }
    return result.toIntArray()
}

fun topKFrequent2(nums: IntArray, k: Int): IntArray {
    val numberFrequency: MutableMap<Int, Int> = mutableMapOf()
    nums.forEach {
        numberFrequency.merge(it, 1) { old, _ -> old + 1 }
    }
    return numberFrequency.toList().sortedByDescending { it.second }.take(k).map { it.first }.toIntArray()
}

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val numberFrequency = mutableMapOf<Int, Int>()
    nums.forEach { numberFrequency.merge(it, 1) { old, _ -> old + 1 } }

    val occurrences = List<MutableList<Int>>(nums.size + 1) { _ -> mutableListOf() }
    numberFrequency.forEach { (number, occ) -> occurrences[occ].add(number) }

    val result = mutableListOf<Int>()
    for (i in occurrences.indices.reversed()) {
        result.addAll(occurrences[i])
        if (result.size == k) return result.toIntArray()
    }

    return intArrayOf()
}