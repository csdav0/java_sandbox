package linkedlists;

public class CircularLinkedList {
    Node head;

    public CircularLinkedList() {
        head = null;
    }

    //insert at beginning method
    public void insertAtBeginning(int data) {
        Node newNodeToAdd = new Node(data);
        //if list is empty, set newNodeToAdd as head and point head to itself
        if (head == null) {
            head = newNodeToAdd;
            newNodeToAdd.next = head;
        }
        //if list is not empty, I need to traverse list to last node before head,
        // make it's pointer point to newNode, then point newNodeToAdd's pointer to previous head
        // then reassign head to newNodeToAdd
        else {
            //sets a node to start at current head
            Node last = head;
            //traverses list by repeatedly reassigning last.next to last reference
            while (last.next != head) {
                last = last.next;
            }
            //assigns last.next pointer to node I want to add
            last.next = newNodeToAdd;
            //assigns newNodeToAdd.next pointer to head
            newNodeToAdd.next = head;
            //reassigns head to be newNodeToAdd
            head = newNodeToAdd;
        }
    }

    //insert in middle method - position argument will be adjacent node preceding newNode
    public void insertInBetween(int data, int position) {
        if (position <= 0) {
            System.out.println("invalid position");
            return;
        }
        Node newNodeToAdd = new Node(data);
        //if list is empty, set newNodeToAdd as head
        if (head == null) {
            if (position == 1) {
                head = newNodeToAdd;
                newNodeToAdd.next = head;
            } else {
                System.out.println("invalid position");
                return;
            }
        } else {
            /* if head is not null, list exists. need to traverse list to position, then
            * insert newNode by having position Node's pointer point to newNode, and newNode's
            * pointer point to Node ahead.*/
            Node current = head;
            int count = 1; //this will serve to track our position as the list is traversed
            while (count < position - 1 && current.next != head) { //while count is not at the Node preceding insertion position, and current has not looped back to head
                current = current.next;
                count++;
            }
            if (count < position - 1) {
                System.out.println("invalid position: position is outside length of circular linked list"); //list would have been entirely traversed and position exceeded length
                return;
            }
            newNodeToAdd.next = current.next; //set newNodeToAdd's pointer to node ahead of position
            current.next = newNodeToAdd; //set current node's pointer to newNodeToAdd
            if (current == head && position == 1) {
                head = newNodeToAdd;
            }
        }
    }

    //insert at end method
    public void insertAtEnd(int data) {
        Node newNodeToAdd = new Node(data);
        if (head == null) {
            head = newNodeToAdd;
            newNodeToAdd.next = head;
        }

        //if list is not empty, traverse list to node before head, then add newNode to point to current.next
        //then set current.next equal to newNode
        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        newNodeToAdd.next = current.next;
        current.next = newNodeToAdd;
    }

    //remove every other node
    public void removeEveryOtherNode() {
        /*stated simple solution was to make every other node point to next node.
        * 1 -> 2 -> 3 -> 4 -> 120  ->  1 -> 3 -> 120
        * to do this I need a current pointer, point it to next next, then traverse to that node
        * and point it to next next, until I have traversed list*/
        if (head == null) {
            return;
        } else {
            Node current = head; //start at head
            if (current.next == head) {
                System.out.println("list has one node");
                return;
            } else {
                do {
                    if (current != null && current.next != head) {
                        current.next = current.next.next;
                        current = current.next;
                    } else {
                        return;
                    }
                } while (current != head);
            }
        }
    }

    //recursion
    public void recursiveRemoval(Node node) {
        //handle list is empty
        if (head == null) {
            return;
        } else {
            if (node.next == head) {
                //handle list has one node
                //stop condition
                return;
            } else if (node.next.next == head) {
                node.next = head;
                return;
            } else {
                node.next = node.next.next;
                recursiveRemoval(node.next);
            }
        }
    }

    //reverse list
    public void reverseListRecursively(Node currentNode, Node previousNode) {
        //make a stop condition
        if (currentNode.next == head) {  //condition to detect last node in list
            currentNode.next.next = currentNode; //point "next" pointer of the old head to new head
            currentNode.next = previousNode; //point "next" pointer of current node to previous node
            head = currentNode; //reassign head label to the current node
            return;
        }
        //break this down to the smallest step: I am at a node and need to point it at previous node
        Node nextNode = currentNode.next; //store reference to next node for recursive call
        currentNode.next = previousNode; //re-point current node's next pointer to previous node
        reverseListRecursively(nextNode, currentNode); //recursive call function w the new nextnode and new previousnode
    }

    //display
    public void display() {
        Node current = head;
        do {
            System.out.println(current.value + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}
