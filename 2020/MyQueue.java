package com.company;

public class MyQueue<T extends Comparable> {

    Node<T> firstNode;
    Node<T> lastNode;
    int count;

    public boolean isEmpty() {
        return firstNode == null;
    }

    public int size() {
        return count;
    }

    // O(1)
    public void enqueue(T newData) {
        count++;

        Node<T> oldLast = lastNode;
        lastNode = new Node<>(newData);
        lastNode.next = null;

        if (isEmpty()) {
            firstNode = lastNode;
        } else {
            oldLast.next = lastNode;
        }
    }

    public T peek() {
        return firstNode.data;
    }

    //O(1)
    public T dequeue() {
        count--;
        T dataDequeue = firstNode.data;
        firstNode = firstNode.next;

        if (isEmpty()) {
            lastNode = null;
        }

        return dataDequeue;
    }
}
