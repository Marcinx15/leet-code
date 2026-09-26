package leetcode_75

fun main() {
    println(canVisitAllRooms(listOf(listOf(1), listOf(2), listOf(3), emptyList())))
    println(canVisitAllRooms(listOf(listOf(1, 3), listOf(3, 0, 1), listOf(2), listOf(0))))
}

fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    val visited = mutableSetOf<Int>()
    val toVisit = ArrayDeque<Int>()
    toVisit.add(0)
    while (toVisit.isNotEmpty()) {
        val current = toVisit.removeFirst()
        if (!visited.contains(current)) {
            rooms[current].forEach { toVisit.add(it) }
            visited.add(current)
        }
    }
    return visited.size == rooms.size
}