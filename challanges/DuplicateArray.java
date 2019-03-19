package arrays;

/* The problem is that we want to find duplicates in a T[] one-dimensional array of integers in O(N) running time where
the integer values are smaller than the length of the array!
 */

import java.util.HashMap;

public class DuplicateArray {

    public static void findDups(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                System.out.print(arr[i] + " is duplicated");
            } else {
                map.put(arr[i], 1);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 1, 2, 5, 2, 3};
        findDups(arr);
    }
}
