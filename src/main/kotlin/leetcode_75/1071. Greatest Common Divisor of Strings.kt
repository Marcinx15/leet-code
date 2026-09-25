package leetcode_75

fun main() {
    val solution = Solution1071()
    val testCases = listOf(
        "ABCABC" to "ABC",
        "ABABAB" to "ABAB",
        "LEET" to "CODE",
        "AAAAAB" to "AAA",
        "XYZ" to "XYZ",
        "NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM" to "NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM"
    )

    testCases.forEach {
        val result = solution.gcdOfStrings(it.first, it.second)
        println(result)
    }
}

private class Solution1071 {
//    fun gcdOfStrings(str1: String, str2: String): String {
//        val shorter = when {
//            str1.length < str2.length -> str1
//            str2.length < str1.length -> str2
//            str1 == str2 -> return str1
//            else -> return ""
//        }
//
//        (shorter.length downTo 1).forEach { divisorLen ->
//            if (str1.length % divisorLen == 0 && str2.length % divisorLen == 0) {
//                val part = shorter.substring(0, divisorLen)
//                if (str1 == part.repeat(str1.length / divisorLen) && str2 == part.repeat(str2.length / divisorLen))
//                    return part
//            }
//        }
//
//        return ""
//    }

//    fun gcdOfStrings(str1: String, str2: String): String {
//        getAllDivisorsReverseSorted(str1.length, str2.length).forEach { divisor ->
//            val part = str1.substring(0, divisor)
//            if (str1 == part.repeat(str1.length / divisor) && str2 == part.repeat(str2.length / divisor))
//                return part
//        }
//        return ""
//    }

    fun gcdOfStrings(str1: String, str2: String) =
        if (str1 + str2 != str2 + str1) ""
        else str1.substring(0, gcd(str1.length, str2.length))



    private fun gcd(f: Int, s: Int): Int = if (s == 0) f else gcd(s, f % s)

//    fun getAllDivisorsReverseSorted(n: Int, m: Int): List<Int> {
//        val gcd = gcd(n, m)
//        if (gcd == 1) return listOf(1)
//        val limit = (sqrt(gcd.toDouble())).toInt()
//        var smallerDivisors = mutableListOf<Int>()
//        val largerDivisors = mutableListOf<Int>()
//        (1..limit).forEach {
//            if (gcd % it == 0) {
//                smallerDivisors = (listOf(it) + smallerDivisors).toMutableList()
//                largerDivisors.add(gcd / it)
//            }
//        }
//        return largerDivisors + smallerDivisors
//    }
}