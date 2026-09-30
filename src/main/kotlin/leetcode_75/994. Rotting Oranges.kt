package leetcode_75

import kotlin.collections.filter
import kotlin.math.min

fun main() {
    val example = arrayOf(intArrayOf(2, 1, 1), intArrayOf(1, 1, 0), intArrayOf(0, 1, 1))
    val example2 = arrayOf(intArrayOf(0))
    val result = orangesRotting(example2)
    println(result)
}


data class Position(val row: Int, val column: Int) {
    fun getAdjacentPositions(): List<Position> =
        listOf(
            Position(row - 1, column),
            Position(row + 1, column),
            Position(row, column + 1),
            Position(row, column - 1)
        )

}

//fun orangesRotting(grid: Array<IntArray>): Int {
//    val rotten = mutableListOf<Position>()
//    val seenWithMinTime = mutableMapOf<Position, Int>()
//    var notEmptySize = 0
//
//    for (i in grid.indices) {
//        for (j in grid[0].indices) {
//            if (grid[i][j] != 0) notEmptySize++
//            if (grid[i][j] == 2) rotten.add(Position(i, j))
//        }
//    }
//
//    rotten.forEach {
//        val queue = ArrayDeque<Pair<Position, Int>>()
//        val seen = mutableSetOf<Position>()
//        queue.add(it to 0)
//        while (queue.isNotEmpty()) {
//            val (current, distance) = queue.removeFirst()
//            if (current !in seen) {
//                seenWithMinTime.merge(current, distance) { oldValue, newValue -> min(oldValue, newValue) }
//                current.apply {
//                    if (row > 0 && grid[row - 1][column] == 1) queue.add(Position(row - 1, column) to distance + 1)
//                    if (row < grid.lastIndex && grid[row + 1][column] == 1) queue.add(Position(row + 1, column) to distance + 1)
//                    if (column > 0 && grid[row][column - 1] == 1) queue.add(Position(row, column - 1) to distance + 1)
//                    if (column < grid[0].lastIndex && grid[row][column + 1] == 1) queue.add(Position(row, column + 1) to distance + 1)
//                }
//                seen.add(current)
//            }
//        }
//    }
//
//    return if (seenWithMinTime.size != notEmptySize) -1
//    else seenWithMinTime.maxOfOrNull { it.value } ?: 0
//}

fun orangesRotting(grid: Array<IntArray>): Int {
    val rotten = mutableSetOf<Position>()
    var fresh = 0

    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == 1) fresh++
            if (grid[i][j] == 2) rotten.add(Position(i, j))
        }
    }

    val queue = ArrayDeque<Pair<Position, Int>>()
    rotten.forEach { queue.add(it to 0) }
    val seen = mutableSetOf<Position>()
    var maxDistance = 0
    while (queue.isNotEmpty()) {
        val (position, distance) = queue.removeFirst()
        if (position !in seen) {
            seen.add(position)
            if (grid[position.row][position.column] == 1) fresh--
            maxDistance = maxOf(distance, maxDistance)
            position.getAdjacentPositions()
                .filter { it.row in grid.indices && it.column in grid[0].indices }
                .forEach { if (grid[it.row][it.column] == 1) queue.add(it to distance + 1) }
        }
    }

    return if (fresh == 0) maxDistance else -1
}