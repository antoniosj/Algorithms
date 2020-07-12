package com.company;

import java.util.TreeMap;

public class MyBST<T extends Comparable> {

    private TreeNode<T> root;

    // Begin - modo de fazer 1
    public void insert(T data) {
        if (root == null) { // primeiro node
            root = new TreeNode<T>(data);
        } else {
            insertNode(data, root);
        }
    }

    // modo de fazer 1
    public void insertNode(T newData, TreeNode<T> root) {
        if (newData.compareTo(root.data) < 0) { // if newData < root.data
            if (root.leftChild != null) {
                insertNode(newData, root.leftChild); // call recursiva com o leftChild sendo o novo root
            } else {
                TreeNode<T> newNode = new TreeNode<>(newData);
                root.leftChild = newNode;
            }
        } else { // if newData >= root.data
            if (root.rightChild != null) {
                insertNode(newData, root.rightChild);
            } else {
                TreeNode<T> newNode = new TreeNode<>(newData);
                root.rightChild = newNode;
            }
        }
    }
    // End - modo de fazer 1

    // begin - modo de fazer 2 (e mais legal)
    public void ins(T newData) {
        root = insRec(root, newData);
    }

    public TreeNode<T> insRec(TreeNode<T> node, T newData) {

        // sempre que acha o local pra colocar o valor do novo node, insere aqui e retorna
        if (node == null) {
            node = new TreeNode<T>(newData);
            return node;
        }

        // vai preenchendo recursivamente os nodes
        if (newData.compareTo(node.data) < 0) {
            node.leftChild = insRec(node.leftChild, newData);
        } else if (newData.compareTo(node.data) > 0) {
            node.rightChild = insRec(node.rightChild, newData);
        }

        // retorna o node sem modificação, caso não consiga encontrar o valor ou seja repetido
        return node;
    }

    public T getMax() {
        return getMax(root);
    }

    public T getMax(TreeNode<T> node) {

        if (node == null) return null;

        if (node.rightChild != null) {
            return getMax(node.rightChild);
        }
        return node.data;
    }

    public T getMin() {
        return getMax(root);
    }

    public T getMin(TreeNode<T> node) {

        if (node == null) return null;

        if (node.leftChild != null) {
            return getMax(node.leftChild);
        }
        return node.data;
    }

    public void traversal() {
//        if (root != null) {
        preOrderTraversal(root);
//        }
    }

    private void inOrderTraversal(TreeNode<T> node) {

        if (node.leftChild != null) {
            inOrderTraversal(node.leftChild);
        }

        System.out.print(node + " --> ");

        if (node.rightChild != null) {
            inOrderTraversal(node.rightChild);
        }
    }

    void postOrderTraversal(TreeNode<T> node) {
        if (node == null)
            return;

        // first recur on left subtree
        postOrderTraversal(node.leftChild);

        // then recur on right subtree
        postOrderTraversal(node.rightChild);

        // now deal with the node
        System.out.print(node.data + " ");
    }

    public void preOrderTraversal(TreeNode<T> node) {

        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");

        preOrderTraversal(node.leftChild);

        preOrderTraversal(node.rightChild);
    }

    public void delete(T data) {
        root = deleteRec(root, data);
    }

    //delete predecessor mode
    public TreeNode<T> delete(T data, TreeNode<T> node) {

        // edge case
        if (node == null) return node;

        // step 1, find the node.
        if (data.compareTo(node.data) < 0) {
            node.leftChild = delete(data, node.leftChild);
        } else if (data.compareTo(node.data) > 0) {
            node.rightChild = delete(data, node.rightChild);
        } else {
            // I have found the data to remove
            // step 2, does it have any children leaf?
            // if it doesn't have any leafs
            if (node.leftChild == null && node.rightChild == null) {
                System.out.println("removing a leaf node");
                return null;
            }

            // if it have only one leaf (right or left)
            if (node.leftChild == null) {
                System.out.println("removing a right child");
                TreeNode<T> temp = node.rightChild;
                node = null;
                return temp;
            } else if (node.rightChild == null) {
                System.out.println("removing a left child");
                TreeNode<T> temp = node.leftChild;
                node = null;
                return temp;
            }

            // if it have 2 leafs // predecessor mode
            System.out.println("removing node with 2 children");
            TreeNode<T> temp = getPredecessor(node.leftChild);
            node.data = temp.data;
            node.leftChild = delete(temp.data, node.leftChild);

        }

        return node;
    }

    TreeNode<T> getPredecessor(TreeNode<T> node) {
        if (node.rightChild != null)
            return getPredecessor(node.rightChild);

        return node;
    }

    TreeNode<T> deleteRec(TreeNode<T> node, T data) {

        if (node == null) return node;

        if (data.compareTo(node.data) < 0) {
            node.leftChild = deleteRec(node.leftChild, data);
        } else if (data.compareTo(node.data) > 0) {
            node.rightChild = deleteRec(node.rightChild, data);
        } else {

            //found
            if (node.leftChild == null) {
                return node.rightChild;
            } else if (node.rightChild == null) {
                return node.leftChild;
            }

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            node.data = minValue(root.rightChild);
            node.rightChild = deleteRec(node.rightChild, node.data);
        }

        return node;
    }

    private T minValue(TreeNode<T> node) {
        T minData = node.data;
        while (node.leftChild != null) {
            minData = node.leftChild.data;
            node = node.leftChild;
        }
        return minData;
    }

}
