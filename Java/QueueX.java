package com.antoniosj;

public class QueueX {
    private int maxSize;
    private long[] queArray;
    private int head;
    private int tail;
    private int nItems;

    public QueueX(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        head = 0;
        tail = -1;
        nItems = 0;
    }

    public void insert(long j) {
        if (tail == maxSize - 1) {
            tail = -1;
        }
        queArray[++tail] = j;
        nItems++;
    }

    public long remove() {
        long temp = queArray[head++];
        if (head == maxSize) {
            head = 0;
        }
        nItems--;
        return temp;
    }

    public long peek() {
        return queArray[head];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }
}
