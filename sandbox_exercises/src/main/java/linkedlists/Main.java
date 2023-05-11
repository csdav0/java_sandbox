package linkedlists;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList circularLinkedList1 = new CircularLinkedList();
        circularLinkedList1.insertAtBeginning(3);
        circularLinkedList1.insertAtBeginning(1);
        circularLinkedList1.insertInBetween(2, 2);
        circularLinkedList1.insertAtEnd(0);
        circularLinkedList1.insertInBetween(2, 4);
        circularLinkedList1.insertInBetween(120, 5);
        circularLinkedList1.insertAtEnd(6);
        circularLinkedList1.display();
        circularLinkedList1.reverseListRecursively(circularLinkedList1.head, null);
//        circularLinkedList1.recursiveRemoval(circularLinkedList1.head);
        circularLinkedList1.display();
//        circularLinkedList1.removeEveryOtherNode();
//        circularLinkedList1.display();
//        circularLinkedList1.removeEveryOtherNode();
//        circularLinkedList1.display();
    }
}
