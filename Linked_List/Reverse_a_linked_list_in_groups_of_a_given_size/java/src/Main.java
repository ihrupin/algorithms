public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> llist = new MyLinkedList<>();
        llist.push(12);
        llist.push(23);
        llist.push(53);
        llist.push(90);
        llist.push(12);
        llist.push(56);
        llist.push(13);
        llist.push(8);
        llist.push(5);

        System.out.println("Given Linked List: " + llist.toString());
        llist.head = llist.reverse(llist.head, 3);
        System.out.println("Reversed Linked List: " + llist.toString());
    }
}
