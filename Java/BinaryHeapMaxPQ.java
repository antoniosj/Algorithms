package com.antoniosj.algsprinceton;

public class BinaryHeapMaxPQ<Key extends Comparable<Key>>  {

    private Key[] pq;
    private int N = 0;

    public BinaryHeapMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity+1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    //quando inserir um novo valor no final da PQ (heap) ele vai dar um swim pra ajustar a heap
    public void insert(Key x) {
        pq[++N] = x;
        swim(N);
    }

    //quando deletar ele da um sink pra ajustar a heap
    public Key delMax() {
        Key max = pq[1]; //Recupera o maior valor do top
        exchange(1, N--); //troca com o último item
        pq[N+1] = null; //evita passar do tamanho do heap
        sink(1); //reajusta a propriadade do heap
        return max;
    }

    //Se depois de inserir um valor, o node ficou maior que seu parent, reorganiza o heap
    private void swim(int k)
    {
        while (k > 1 && less(k/2, k))
        {
            exchange(k/2, k);
            k = k/2;
        }
    }

    //se depois de uma remoção o node ficou menor que os children, reordena com o child com maior valor.
    private void sink(int k)
    {
        while (2*k <= N)
        {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

    //i < j = -1 | i == j = 0 | i > j = 1
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    //swap dos valores
    private void exchange(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
