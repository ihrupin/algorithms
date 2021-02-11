fun main() {
    val llist = MyLinkedList<Int>()
    llist.push(13)
    llist.push(5)
    llist.push(98)
    llist.push(8)

    println("Given Linked List: $llist")
    llist.reverse()
    println("Reversed Linked List: $llist")
}