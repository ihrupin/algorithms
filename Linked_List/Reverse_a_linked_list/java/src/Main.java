public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> llist = new MyLinkedList<>();
        llist.push(13);
        llist.push(5);
        llist.push(98);
        llist.push(8);

        System.out.println("Given Linked List: " + llist.toString());
        llist.reverse();
        System.out.println("Reversed Linked List: " + llist.toString());
    }
}
