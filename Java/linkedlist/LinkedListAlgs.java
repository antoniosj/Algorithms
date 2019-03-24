package com.antoniosj;

public class LinkedListAlgs {

    Node head = null;

    public void appendToTail(int d) {
        if (head == null)
            head = new Node(d);
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(d);
        }
    }

    public void appendToHead(int dat) {
        Node temp = head;
        head = new Node(dat);
        head.next = temp;
    }

    public Node deleteNode(Node newNode, int d) {
        Node n = newNode;

        if (n.data == d) {
            return newNode.next;
        }

        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return newNode;
            }
            n = n.next;
        }
        return newNode;
    }

}
