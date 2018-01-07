package com.coreJ;

public class Matrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arry ={{1,1,1,1},{0,0,1,1},{0,1,1,1},{0,0,1,1}};
		//dispaly
		for(int i=0;i<4;i++)
		{
		int[] aryRow = arry[i];
		for(int x : aryRow)
			System.out.print("\t"+x);
		System.out.println("\n");
		}
		int row=-1;
		int temp=-1;int index1s;
		for(int i=0;i<4;i++)
		{
			
			index1s = binarySearchRec(arry[i],0,arry.length-1,1);	
			
			if(arry[i][index1s]==1 && arry[i][index1s-1]==1)
			{
				row=i;
				temp=index1s;
				break; //no need to check further
			}
			else if(temp==-1 || ((index1s<temp ) && (index1s !=-1)))
			{
				temp=index1s;row=i;
				
			}						
		}
		System.out.println("ROW NO HAS MAX 1's : "+row);

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

}
