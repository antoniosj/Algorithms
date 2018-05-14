package com.antoniosj;

public class BST {

    class TNode {
        int data;
        TNode left, right;

        public TNode(int d) {
            data = d;
            left = right = null;
        }
    }

    static TNode root;

    public BST() {
        root = null;
    }

    public static void main(String[] args) {

        BST bst = new BST();
        bst.put(8);
        bst.put(10);
        bst.put(11);

        bst.delete(10);

    }

    public void put(int value){
        root = put(root, value);
    }

    public TNode put(TNode root, int value) {

        if (root == null) {
            root = new TNode(value);
            return root;
        }

        if (value < root.data) {
            root.left = put(root.left, value);
        } else {
            root.right = put(root.right, value);
        }

        return root;
    }

    public TNode find(TNode root, int value) {

        if (root == null || root.data == value) {
            return root;
        }

        if (root.data > value) {
            return find(root.left, value);
        }

        return find(root.right, value);
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    public TNode delete(TNode root, int value) {

        if (root == null) {
            return root;
        }

        if (root.data > value) {
            root.left = delete(root.left, value);
        } else if (root.data < value) {
            root.right = delete(root.right, value);

        } else {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data =  minValue(root.right);

            root.right = delete(root.right, root.data);
        }
        return root;
    }

    int minValue(TNode root)
    {
        int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }


}
