public class MyLinkedList<T> {
    Node<T> head = null;

    public void reverse() {
        Node<T> previous = null;
        Node<T> current = this.head;

        while (current != null) {
            Node<T> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        this.head = previous;
    }

    public void push(T newData) {
        Node<T> newNode = new Node<>(newData);
        newNode.next = this.head;
        this.head = newNode;
    }

    @Override
    public String toString() {
        Node<T> temp = head;
        StringBuilder builder = new StringBuilder();

        while (temp != null) {
            builder.append(temp.data);
            temp = temp.next;

            if (temp != null) {
                builder.append("--->");
            } else {
                builder.append("--->NULL");
            }
        }

        return builder.toString();
    }
}
