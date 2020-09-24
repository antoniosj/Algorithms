package com.antoniosj.challanges;

// Linked List

public class ReverseLinkedList {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode temp;
        ListNode prev = null;

        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }


    public static void main(String args[]) {

        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        reverseList(n);
    }
}
