package data;

public class MyArrayStack {

    private int[] stack;
    private int numOfItems;

    public MyArrayStack() {
        this.stack = new int[1];
    }

    public void push(int value) {

        if (stack.length == numOfItems) {
            resize(2*numOfItems);
        }
        /*
        * equivalente:
        * stack[numberOfitems] = values;
        * numberofitems++;
        */
        stack[numOfItems++] = value;
    }

    public void resize(int capacity) {
        int[] copyArr = new int[capacity];
        for (int i = 0; i < stack.length; i++) {
            copyArr[i] = stack[i];
        }
        stack = copyArr;
    }

    public int pop() {
        if (isEmpty()) return -1;
        int itemPop = this.stack[--numOfItems];

        if (numOfItems > 0 && numOfItems == stack.length / 4) {
            resize(stack.length/2);
        }

        return itemPop;
    }

    public int peek() {
        return stack[numOfItems-1];
    }

    public boolean isEmpty() {
        return numOfItems == 0;
    }

    public int size() {
        return numOfItems;
    }
}
