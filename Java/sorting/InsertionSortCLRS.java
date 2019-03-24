
public class InsertionSortCLRS {

	public static void main(String[] args) {
		int[] testSorting = new int[] {3 ,4, 10, 6, 1};
		insertionSort(testSorting);
	}
	
	public static void insertionSort(int[] list) {
		int i, key = Integer.MIN_VALUE;
		
		for (int j = 2; j < list.length; j++) {
			key = list[j];
			i = j - 1;
			while (i >= 0 && list[i] > key) {
				list[i + 1] = list[i];
				i = i - 1;
			}		
			list[i + 1] = key;
		}	
		StringBuffer sb = new StringBuffer();
		for (int item : list){
			sb.append(item);
			sb.append(" ");
		}
		System.out.print(sb);
	}

}
