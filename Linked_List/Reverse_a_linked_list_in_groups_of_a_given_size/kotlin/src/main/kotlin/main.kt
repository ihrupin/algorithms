fun main() {
    val llist = MyLinkedList<Int>()
    llist.push(12)
    llist.push(23)
    llist.push(53)
    llist.push(90)
    llist.push(12)
    llist.push(56)
    llist.push(13)
    llist.push(8)
    llist.push(5)

    println("Given Linked List: $llist")
    llist.head = llist.reverse(llist.head, 3)
    println("Reversed Linked List: $llist")
}