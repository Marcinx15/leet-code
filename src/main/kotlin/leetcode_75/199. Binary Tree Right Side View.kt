package leetcode_75

fun main() {
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node4 = TreeNode(4)
    val node5 = TreeNode(5)

    node1.left = node2
    node1.right = node3
    node2.right = node5
    node3.right = node4

    println(rightSideView(node1))
}


fun rightSideView(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()

    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    val result = mutableListOf<Int>()
    while (queue.isNotEmpty()) {
        result.add(queue.last().value)
        val len = queue.size
        repeat(len) {
            val node = queue.removeFirst()
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
    }
    return result
}

