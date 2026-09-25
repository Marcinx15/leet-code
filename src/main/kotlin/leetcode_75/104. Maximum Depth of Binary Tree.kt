package leetcode_75

import kotlin.math.max

fun main() {
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node4 = TreeNode(4)
    val node5 = TreeNode(5)
    val node6 = TreeNode(6)

    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node5
    node5.right = node6

    println(maxDepth(node1))
}


class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


fun maxDepth(root: TreeNode?): Int =
    if (root == null) 0
    else max(maxDepth(root.left), maxDepth(root.right)) + 1
