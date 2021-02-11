import java.lang.StringBuilder

class MyLinkedList<T> {
    var head: Node<T>? = null

    fun reverse(head: Node<T>?, k: Int): Node<T>? {
        var previous: Node<T>? = null
        var next: Node<T>? = null
        var current = head
        var count = 0

        while (current != null && count < k) {
            next = current.next
            current.next = previous
            previous = current
            current = next
            count++
        }

        if (next != null) {
            head?.next = reverse(next, k)
        }

        return previous
    }

    fun push(newData: T) {
        val newNode = Node(newData)
        newNode.next = head
        head = newNode
    }

    override fun toString(): String {
        var temp = head
        val builder = StringBuilder()
        while (temp != null) {
            builder.append(temp.data)
            temp = temp.next
            if (temp != null) {
                builder.append("--->")
            } else {
                builder.append("--->NULL")
            }
        }
        return builder.toString()
    }
}