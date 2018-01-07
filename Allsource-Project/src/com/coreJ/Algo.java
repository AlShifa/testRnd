package com.coreJ;

import java.util.Arrays;

public class Algo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fac = fact(3);
		System.out.println(fac);
		int fab = fabo(5);
		System.out.println(fab);
		System.out.println(faboRecur(5));
		int x = 23367897;
		int y = reverseIntegerRec(x,0);
		System.out.println(y);
		int[] sortedArry ={2,2,2,2,2,2,2};
		int found = binarySearch(sortedArry, 7);
		//Arrays.binarySearch(a, key)
		//Arrays.sort(a);
		System.out.println(found);
		int indexLoc = binarySearchRec(sortedArry,0, sortedArry.length-1 , 2);
		//alwyas give mid value, not first index.
		System.out.println(indexLoc);
	}
	static int binarySearchRec(int[] sortedArry, int x, int y , int search)
	{
		if(x>y) 
			return -1;
		
		 if(search > sortedArry[(x+y)/2])
			return binarySearchRec(sortedArry,((x+y)/2)+1 , y, search);
		 
		else if(search<  sortedArry[(x+y)/2])
			return binarySearchRec(sortedArry,x,((x+y)/2)-1 ,search );
		 
		else if(search==sortedArry[(x+y)/2])
			return (x+y)/2;
		 
		else return -1;
	}
	
	static int binarySearch(int[] sortedArry, int search )
	{
		int i = 0;
		int j = sortedArry.length-1;
		while(i<j )
		{
			int mid = (i+j)/2;
			int temp = sortedArry[mid];
			if(search < temp)	//left search
				j = mid;			
			else if(search > temp)//right search
				i = mid+1;
			else return mid;			
		}
		return -1;
			
	}
	
	
	//reverse using recursion
	static int reverseIntegerRec(int n,int r)
	{
		if(n==0)
			return r;
		else
			return  reverseIntegerRec(n/10, r*10 + n%10 );
	}
	//fibo using recursion
	static int faboRecur(int n)
	{
		if(n<3)
			return 1;
		else return faboRecur(n-1)+faboRecur(n-2);
		
	}
	static int fabo(int n)
	{
		
		int i=1;
		int j=1;
		int sum=1; //=i+j;
		while(n>2)
		{
			sum=i+j;
			i=j;
			j=sum;			
			n--;
		}
		return sum;
	}
	static int fact(int n)
	{
		if(n==1)
			return 1;
		return n*fact(n-1);
		
	}

}
