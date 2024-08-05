package top_interview_150.array

fun main() {
    val board: Array<CharArray> = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    println(isValidSudoku2(board))

}

fun isValidSudoku(board: Array<CharArray>): Boolean {
    board.forEach { if (!isValid(it)) return false }

    val columns = Array(board.size) { mutableListOf<Char>() }
    board.forEach { it.forEachIndexed { index, value -> columns[index].add(value) } }
    columns.forEach { if (!isValid(it.toCharArray())) return false }

    val squares = Array(board.size) { mutableListOf<Char>() }
    board.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { columnIndex, value ->
            squares[rowIndex / 3 * 3 + columnIndex / 3].add(value)
        }
    }
    squares.forEach { if (!isValid(it.toCharArray())) return false }

    return true
}

fun isValid(row: CharArray): Boolean {
    val seen: MutableSet<Char> = mutableSetOf()
    row.forEach {
        if (it != '.') {
            if (seen.contains(it)) return false
            else seen.add(it)
        }
    }
    return true
}

fun isValidSudoku2(board: Array<CharArray>): Boolean {
    val rowSets = Array(board.size) { mutableSetOf<Char>() }
    val columnSets = Array(board.size) { mutableSetOf<Char>() }
    val squareSets = Array(board.size) { mutableSetOf<Char>() }

    board.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { columnIndex, value ->
            if (value != '.') {
                val squareIndex = rowIndex / 3 * 3 + columnIndex / 3
                if (value in rowSets[rowIndex] || value in columnSets[columnIndex] || value in squareSets[squareIndex])
                    return false

                rowSets[rowIndex].add(value)
                columnSets[columnIndex].add(value)
                squareSets[rowIndex / 3 * 3 + columnIndex / 3].add(value)
            }
        }
    }
    return true
}
