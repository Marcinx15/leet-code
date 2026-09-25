package leetcode_75

fun main() {
    val recentCounter = RecentCounter()
    println(recentCounter.ping(1)) // requests = [1], range is [-2999,1], return 1
    println(recentCounter.ping(100)) // requests = [1, 100], range is [-2900,100], return 2
    println(recentCounter.ping(3001)) // requests = [1, 100, 3001], range is [1,3001], return 3
    println(recentCounter.ping(3002)) // requests = [1, 100, 3001, 3002], range is [2,3002], return
}

class RecentCounter() {

    val pingTimeRecords = ArrayDeque<Int>()

    fun ping(t: Int): Int {
        pingTimeRecords.add(t)
        while (pingTimeRecords.first() < t - 3000) pingTimeRecords.removeFirst()
        return pingTimeRecords.size
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */