import data.Node;

public class MyLinkedList {

    // this head must always contain the entire values
    Node head;
    int size;

    //O (1)
    public void insertAtHead(int data) {
        if (head == null) {
            this.head = new Node(data);
        } else {
            // 1 - create a new node
            Node newNode = new Node(data);
            // 2 - point the next value to the head
            // ex: 1 -> 2 ->  and newNode = 5 ->
            // newNode = 5 -> 1 -> 2 -> null
            newNode.next = head;
            // then set head to be this new structure
            head = newNode;
            //option update size
            size++;
        }
    }

    public void insetAtTail(int data) {

        // head cannot start as null. There's no null -> 1 but there's 1 -> null
        if (head == null) {
            head = new Node(data);
        } else {
            // n = n.next doesn't change head, but n.next = something would change it.
            //
            Node newNode = head;
            // newNode.next instead of newNode != null because if I want to change head
            // I need to modify exactly the right reference, instead of a copy of a reference
            // like newNode pointing to head would be.
            while (newNode.next != null) {
                newNode = newNode.next;
            }
            // this is enough to change head too.
            newNode.next = new Node(data);
            //won't need to reassign like this: head = newNode; after line 43.

        }
        size++;
    }


    public Node remove(int data) {

        Node n = head;

        //edge cases
        if (n == null) return n;

        if (n.data == data) {
            --size;
            return n.next;
        }

        //if I find the value I skip this value and this will modify the head
        while (n.next != null) {
            // 1 -> [2 ->] -> 3 to 1 -> 3 ->
            if (n.next.data == data) {
                n.next = n.next.next;
                --size;
                return head;
            }
            n = n.next;
        }

        return null;
    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
}
