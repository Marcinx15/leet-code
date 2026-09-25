package leetcode_75

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    printList(node1)
    val solution = Solution()
    println()
    printList(solution.reverseList(node1))
}

class ListNode(var value: Int) {
    var next: ListNode? = null
}

fun printList(head: ListNode?) {
    var current = head
    while (current != null) {
        print("${current.value} ")
        current = current.next
    }

}

class Solution {
    fun reverseList2(head: ListNode?): ListNode? {
        var currentNode: ListNode? = head
        var previousNode: ListNode? = null
        while (currentNode != null) {
            val nextNode = currentNode.next
            currentNode.next = previousNode
            previousNode = currentNode
            currentNode = nextNode
        }
        return previousNode
    }

    fun reverseList(head: ListNode?): ListNode? {
        tailrec fun revereListRec(prev: ListNode?, current: ListNode?): ListNode? =
            if (current == null)  prev
            else {
                val nextNode = current.next
                current.next = prev
                revereListRec(current, nextNode)
            }

        return revereListRec(null, head)
    }
}