package com.coreJ;

public class AlgoRec {

	public static void main(String[] args) {
		int[] arry ={11,12,13,4,5,6,7,8,1};
		int value = sum(arry, arry.length-1);	
		System.out.println(value);
		int valueBin = sumUsingBinaryRec(arry,0,arry.length-1);
		System.out.println("[ valueBin ]"+valueBin);
	}
	//sum using binary recursive
	public static int sumUsingBinaryRec(int[] arry,int x ,int y )
	{
		if(x==y)
		{
				System.out.println(x+"[ ]"+y);
				return arry[x];
		}
		else
		{			
			System.out.println("[x]"+x+"[x+y/2]"+(x+y)/2);
			int k =sumUsingBinaryRec(arry, x ,(x+y)/2 );
			System.out.println("[ K ]"+k);
			int p =sumUsingBinaryRec(arry,((x+y)/2)+1 , y );
			System.out.println("[ p ]"+p);
			return  k+p ;
		}
		
	}
	
	
	
	//sum through linear recursive
	public static int sum(int[] arry, int y)
	{
		//System.out.println("call function "+y);
		if(y==0)
			return arry[y];
		else
		{
			int k = arry[y];
			int p = sum(arry,y-1);
			//System.out.println("back track"+p);
			return k+p ;
		}
			
		
	}

}
