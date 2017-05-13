package io.github.antoniosj.chapter1;

public class QuickUnionUF {

	private int[] id;
	
	public QuickUnionUF(int N) {
		id = new int[N];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}
	
	public int root(int element){
		while (element != id[element]){
			element = id[element];
		}
		return element;
	}
	
	public boolean connect(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q){
		int i = root(p);
		int j = root(q);
		id[i] = j;
	
	}
	
	
}
