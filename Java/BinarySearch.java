package com.company;

import java.util.Arrays;

public class BinarySearch {


    static int search(int arr[], int size, int value) {

        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {

            int mid = (hi + lo) / 2;

            if (arr[mid] >= value) {
                hi = mid - 1;
            } else if (arr[mid] > value){
                hi = mid - 1;
            } else if (arr[mid] == value) {
                return arr[mid];
            }
        }

        return -1;
    }






    public static void main (String[] args)
    {
        int arr[] = { 3, 4, 5, 6, 7, 11 };
        int n = arr.length;

        // Preprocess array
        Arrays.sort(arr);

       System.out.println( search(arr, n, 7));

    }
}
