package com.sg.ds;

public class DS {
	public static void main(String[] args) {
		int[] a = { 2, 3, 4, 5, 1, 2, 9 };
		int x = sumElemt(a);
		swap(a);
		for (int i : a) {
			System.out.print(i);
		}
	}

	private static void swap(int[] a) {
		int mid = a.length/2;
		int i = 0;
		int j = a.length-1;
		while (i < mid)  {
			int temp=a[i];
			a[i]= a[j];
			a[j] = temp;
			i++;j--;
		}
	}

	static int sumElemt(int[] a) {
		int len = a.length;
		int sum = 0;
		while (len > 0) {
			sum = sum + a[len - 1];
			len--;
		}
		System.out.println(sum);
		return sum;
	}

}
