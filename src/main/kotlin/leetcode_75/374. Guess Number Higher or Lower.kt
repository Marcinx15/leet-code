package leetcode_75

fun main() {
    val solution = Solution123()
    solution.pick = 1
    println(solution.guessNumber(1))
    println(solution.guessNumber(2))
    println(solution.guessNumber(100))
}

/**
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return         -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */

abstract class GuessGame {
    var pick = 0

    fun guess(num: Int): Int =
        when {
            num > pick -> -1
            num < pick -> 1
            else -> 0
        }

    abstract fun guessNumber(n: Int): Int
}

class Solution123 : GuessGame() {
    override fun guessNumber(n: Int): Int {
        tailrec fun g(from: Int, to: Int): Int {
            val toGuess = from + (to - from) / 2
            return when (guess(toGuess)) {
                -1 -> g(from, toGuess - 1)
                1 -> g(toGuess + 1, to)
                else -> toGuess
            }
        }
        return g(1, n)
    }
}