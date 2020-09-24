import data.Node;

public class MyStack<T extends Comparable<T>> {

    public Node<T> root;
    public int count;

    // O(1)
    public void push(T newData) {
        count++;

        if (root == null) {
            root = new Node<>(newData);
        } else {
            Node<T> prevRoot = this.root;
            root = new Node<>(newData);
            root.next = prevRoot;
        }
    }

    public T pop() {
        T popItem = root.data;
        root = root.next;
        count--;
        return popItem;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public T peek() {
        return root.data;
    }

}
