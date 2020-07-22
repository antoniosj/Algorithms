package com.company;

import sun.reflect.generics.tree.Tree;

public class TreeNode<T> {

    T data;
    TreeNode<T> leftChild;
    TreeNode<T> rightChild;

    public TreeNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
