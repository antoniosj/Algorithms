package io.github.antoniosj.chapter1;

import edu.princeton.cs.algs4.StaticSETofInts;

public class StackImpl {

	public int[] list = new int[5];
	public int N = 0;

	public void push(int item) {
		if (N >= list.length - 1) {
			System.out.println("pilha cheia");
		} else {
			list[N] = item;
			N++;
			System.out.println("pushing: " + item + " stack size: " + N);
		}
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int peek() {

		return N;

	}

	public void pop() {

		if (!isEmpty()) {
			list[--N] = 0;
			--N;
			System.out.println("stack size: " + N);
		}
	}

	public static void main(String[] args) {
		StackImpl i = new StackImpl();
		i.push(1);
		i.push(3);
		i.push(4);

		int peek = i.peek();
		System.out.println("peek:" + peek);
		i.pop();
		peek = i.peek();
		System.out.println("peek:" + peek);

		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < i.list.length; j++) {
			sb.append(i.list[j]);
			sb.append(" ");
		}
		System.out.print(sb);
	}

}
