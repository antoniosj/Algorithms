package io.github.antoniosj.chapter1;

import edu.princeton.cs.algs4.*;

/*
 * Checking if objects are connected by its ID.
 * https://www.coursera.org/learn/algorithms-part1/lecture/EcF3P/quick-find
 */

public class QuickFindUF {

	private int[] id;

	// Starting all numbers if the same ID of the Index
	public QuickFindUF(int N) {
		
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	// checking if elements are already connected
	public boolean connected(int p, int q) {
		
		return id[p] == id[q];
	}

	// linking elements
	public void union(int p, int q) {
		
		int pId = id[p];
		int qId = id[q];

		for (int i = 0; i < id.length; i++) {
			if (id[i] == pId) {
				id[i] = qId;
			}
		}

		
	}

}
