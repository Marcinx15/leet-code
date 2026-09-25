package leetcode_75

fun main() {
    println(largestAltitude(intArrayOf(-5,1,5,0,-7)))
    println(largestAltitude(intArrayOf(-4,-3,-2,-1,4,3,2)))
}

private fun largestAltitude(gain: IntArray): Int {
    var highestAltitude = 0
    var currentAltitude = 0
    gain.forEach {
        currentAltitude += it
        if (currentAltitude > highestAltitude) highestAltitude = currentAltitude
    }
    return highestAltitude
}