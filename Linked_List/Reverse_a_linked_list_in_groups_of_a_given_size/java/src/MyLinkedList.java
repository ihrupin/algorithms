public class MyLinkedList<T> {
    Node<T> head = null;

    public Node<T> reverse(Node<T> head, int k) {
        Node<T> current = head;
        Node<T> next = null;
        Node<T> previous = null;
        int count = 0;

        while (current != null && count < k) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }

        if (next != null) {
            head.next = reverse(next, k);
        }

        return previous;
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
