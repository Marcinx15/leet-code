package leetcode_75

fun main() {
    val node1 = TreeNode(4)
    val node2 = TreeNode(2)
    val node3 = TreeNode(7)
    val node4 = TreeNode(1)
    val node5 = TreeNode(3)

    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node5

    val result = searchBST(node1, 10)
    println(result?.value)
    println(result?.left?.value)
    println(result?.right?.value)

}

fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    return when {
        root == null -> null
        root.value == `val` -> root
        root.value < `val` -> searchBST(root.right, `val`)
        else -> searchBST(root.left, `val`)
    }
}