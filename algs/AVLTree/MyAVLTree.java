package com.company;

public class MyAVLTree {

    AvlNode root;

    public void insert(int data) {
        root = insert(root, data);
    }

    private AvlNode insert(AvlNode node, int data) {
        if (node == null) {
            return new AvlNode(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        node = settleViolation(data, node);

        /* return the (unchanged) node pointer */
        return node;
    }

    private AvlNode settleViolation(int data, AvlNode node) {
        // if difference is not greater than 1 its balanced = N >= -1 and <= 1
        // if difference is > 1  then left > right = so we do right rotation
        // if difference is < -1 then right < left = so we do left rotation
        int balance = getBalance(node);

        // case 1: double left heavy or left-left = single right rotation
        if (balance > 1 && data < node.left.data) {
            return rotateRight(node);
        }

        // case 2: double right heavy or right-right = single left rotation
        if (balance < -1 && data > node.right.data) {
            return rotateLeft(node);
        }

        // case 3: left-right =
        if (balance > 1 && data > node.left.data) {
            node.left = rotateLeft(node.left); // rotate the parent
            return rotateRight(node);
        }

        // case 4: right-left
        if (balance < -1 && data < node.right.data) {
            node.right = rotateRight(node.right); // rotate the parent
            return rotateLeft(node);
        }

        return node;
    }


    private AvlNode rotateRight(AvlNode node) {
        System.out.println("rotating to the right...");

        AvlNode tempLeft = node.left;
        AvlNode tempLeftRight = tempLeft.right;

        tempLeft.right = node;
        node.left = tempLeftRight;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        tempLeft.height = Math.max(getHeight(tempLeft.left), getHeight(tempLeft.right)) + 1;

        return tempLeft;
    }

    private AvlNode rotateLeft(AvlNode node) {
        System.out.println("rotating to the left...");

        AvlNode tempRight = node.right;
        AvlNode tempRightLeft = tempRight.left;

        tempRight.left = node;
        node.right = tempRightLeft;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        tempRight.height = Math.max(getHeight(tempRight.left), getHeight(tempRight.right)) + 1;

        return tempRight;
    }

    public void traverse() {
        if (root == null) return;

        preOrderTraversal(root);
    }

    private int getHeight(AvlNode node) {
        if (node == null) return -1;
        return node.height;
    }

    private int getBalance(AvlNode node) {
        if (node == null) {
            return 0; //balanced
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // left root right
    private void preOrderTraversal(AvlNode node) {

            if (node == null) {
                return;
            }

            System.out.print(node.data + " ");

            preOrderTraversal(node.left);

            preOrderTraversal(node.right);
    }

    // BEGIN delete
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    AvlNode deleteRec(AvlNode node, int data) {

        if (node == null) return node;

        if (data < node.data) {
            node.left = deleteRec(node.left, data);
        } else if (data > node.data) {
            node.right = deleteRec(node.right, data);
        } else {

            //found
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            node.data = minValue(root.right);
            node.right = deleteRec(node.right, node.data);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        return settleDeletion(node);
    }

    private int minValue(AvlNode node) {
        int minData = node.data;
        while (node.left != null) {
            minData = node.left.data;
            node = node.left;
        }
        return minData;
    }


    private AvlNode settleDeletion(AvlNode node) {

        int balance = getBalance(node);

        // tree can be left-left or left-right
        if (balance > 1) {
            // left-right = rotate parent left then grandparent right below
            if (getBalance(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            // left-left = just rotate grandparent right
            return rotateRight(node);
        }

        // tree can be right-right or right-left
        if (balance < -1) {
            // right-left = rotate parent right then grandparent left below
            if (getBalance(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            // right-right = just rotate grandparent left
            return rotateLeft(node);
        }

        return node;
    }

    // END Delete
}
