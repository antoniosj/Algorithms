package com.antoniosj;

import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int nElements = a.length;
        int temp;

        //bubblesort Big O = N^2
        for (int i = 0; i < nElements; i++){
            for (int j = 0; j < nElements - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}
