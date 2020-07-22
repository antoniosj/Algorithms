package com.company;

public class AvlNode {

    int data;
    AvlNode left;
    AvlNode right;
    int height;

    public AvlNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data + " - ";
    }
}
