package com.antoniosj;

public class InsertionSort {

    private long[] a;
    private int nElems;

    public InsertionSort(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }


    public void insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;                      // start shifts at out
            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];            // shift item right,
                --in;                       // go left one position
            }
            a[in] = temp;                  // insert marked item
        }
    }

}
