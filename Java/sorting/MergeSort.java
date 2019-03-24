package io.github.antoniosj.chapter1;

public class MergeSort {
	private int[] numbers;
	private int[] helper;

	private int number;

	public void sort(int[] values) {
		this.numbers = values;
		number = values.length;
		this.helper = new int[number];
		mergesort(0, number - 1);
	}

	private void mergesort(int low, int high) {
		
		if (low < high) {
			
			int middle = low + (high - low) / 2;
			
			mergesort(low, middle);
			
			mergesort(middle + 1, high);
			
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {

		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}

	}
	
	
	
	
	public static void main(String[] args) {
    	int[] a = new int[] { 3, 2, 5, 1, 5 };
    	MergeSortII m = new MergeSortII();
    	m.sort(a);
    	
    	StringBuffer sb = new StringBuffer();
    	for (int i = 0; i < a.length; i++){
    	sb.append(a[i]);
    	sb.append(" ");
    	}
    	System.out.print(sb);
	}

}
