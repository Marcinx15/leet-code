package top_interview_150.array

fun main() {
    println(romanToInt(s = "III"))
    println(romanToInt(s = "LVIII"))
    println(romanToInt(s = "MCMXCIV"))
}

fun romanToInt(s: String): Int {
    return s.foldIndexed(0) { index, acc, value ->
        acc + numeralToInt(value, s.getOrNull(index + 1))
    }
}

fun numeralToInt(numeral: Char, nextNumeral: Char?) =
    when (numeral) {
        'M' -> 1000
        'D' -> 500
        'L' -> 50
        'V' -> 5
        'C' -> if (nextNumeral != null && nextNumeral in charArrayOf('D', 'M')) -100 else 100
        'X' -> if (nextNumeral != null && nextNumeral in charArrayOf('L', 'C')) -10 else 10
        'I' -> if (nextNumeral != null && nextNumeral in charArrayOf('V', 'X')) -1 else 1
        else -> throw IllegalArgumentException()
    }
