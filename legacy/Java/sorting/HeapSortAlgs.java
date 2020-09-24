package com.antoniosj.algsprinceton;

public class HeapSortAlgs {

    public HeapSortAlgs() {

    }

    public static void sort(Comparable[] pq) {
        int n = pq.length;
        for (int k = n/2; k >= 1; k--)
            sink(pq, k, n);
        while (n > 1) {
            exchange(pq, 1, n--);
            sink(pq, 1, n);
        }
    }

    //se depois de uma remoção o node ficou menor que os children, reordena com o child com maior valor.
    private static void sink(Comparable[] pq, int k, int n)
    {
        while (2*k <= n)
        {
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exchange(pq, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    //swap dos valores
    private static void exchange(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
