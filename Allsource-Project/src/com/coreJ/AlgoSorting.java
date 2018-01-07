package com.coreJ;

public class AlgoSorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arry = { 1, 4, 6, 9, 3, 5, 2 };
		bubbleSort(arry, 0, arry.length - 1);
		for (int x : arry)
			System.out.print(x);

	}

	static void bubbleSort(int[] array, int x, int y) {
		if (x < y) {
			internal(array, x, y);
			bubbleSort(array, 0, y - 1);
			}
		}

	static void internal(int[] array, int x, int y) {
		
		if (x < y) {
			if (array[x] > array[x+1]) {
				int temp = array[x];
				array[x] = array[x+1];
				array[x+1] = temp;				
			}
			internal(array, x + 1, y);
		}
	}
}
