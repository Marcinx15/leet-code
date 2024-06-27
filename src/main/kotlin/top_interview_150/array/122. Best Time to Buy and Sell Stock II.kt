package top_interview_150.array

fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    println(maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}

fun maxProfit(prices: IntArray): Int {
    var totalProfit = 0
    for (i in 0 until prices.lastIndex) {
        val profit = prices[i + 1] - prices[i]
        if (profit > 0) totalProfit += profit
    }
    return totalProfit
}
