package com.coreJ;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Observer;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	//JVM entry point
	public static void main(String[] args) throws IOException {
		
		//Object
		
		// TODO Auto-generated method stub
		//int x =9000;
		//System.out.println(ManagementFactory.getRuntimeMXBean().getName());
		//while(true);
		int sortArry[] = {1,1,2,2,2,3,5,6,6,6};
		int elemDup[] = new int[sortArry.length];
		int i=1;
		int j=0;
		elemDup[0] = sortArry[0];
		while(i<sortArry.length)
		{
			System.out.println("dd");
			if(sortArry[i] != elemDup[j]){
				j++;
				elemDup[j]=sortArry[i];					
			}
			i++;
		}
		for(int y : elemDup)
			//System.out.print(y);
		
		System.out.println("\\n");
		
		String str = "GHOST";
		int i1=str.length()-1;
		StringBuffer sb = new StringBuffer();
		/*while(i1>=0){
			sb.append(str.charAt(i1));
			i1--;
			}*/
		//System.out.println(sb);
		//reverse(5,sb,str);
		//System.out.println(sb);		
		str="YESSIR";
		char[] arry = str.toCharArray();
		System.out.println(arry.length);
		reverserCharArry(arry,0 , arry.length-1 );
		System.out.println(arry);
		
		int[] intArry = {9,1,4,3,8,5};
		bubbleSort(intArry,0,intArry.length-1);
		for(int k : intArry)
			System.out.print(k);
		System.out.println("\n");
		
		int[] intArry1 = {0,1,4,3,8,5};
		selectionSort(intArry1,0,intArry1.length-1);
		for(int k : intArry1)
			System.out.print(k);
		
		 
	}
	
	//without rescursion
	
	static void selectionSort(int[] intArray , int x , int y)
	{
		for(int i=0;i<y;i++)
		{
			int temp=intArray[i];			
			for(int j =i+1; j<=y ;j++)
			{
				if(temp>intArray[j])
				{
					intArray[i]=intArray[j];
					intArray[j]=temp;
				}
			}
		}
	}
	//without recursive
	static void bubbleSort(int[] intArray , int x , int y)
	{
		for(int i=y; i>0 ; i--)
			for(int j=0; j< i ;j++)
			{
				if(intArray[j]>intArray[j+1])
				{
					int temp = intArray[j];intArray[j]=intArray[j+1];
					intArray[j+1]=temp;
				}
			}
			
	}
	
		//reverse of an arry without substring 
	static void reverserCharArry(char[] arry , int i, int j)
	{
		if(i<=j)
		{
			//swap(arry,i,j);
			char c = arry[i];
			arry[i]=arry[j];
			arry[j]=c;
			i++;j--;
			reverserCharArry(arry,i,j);
		}
		
	}
	static void reverse(int i,StringBuffer sb,String str)
	{
		if(i>0)
		{
			i--; 
			reverse(i,sb.append(str.charAt(i)),str );		
		}
		if(i==0)sb.append(str.charAt(0));
	}

}
