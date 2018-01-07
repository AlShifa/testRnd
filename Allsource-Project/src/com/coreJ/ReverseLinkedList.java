package com.coreJ;

public class ReverseLinkedList {

	/**
	 * @param args
	 */
	static int reveCount=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary ={2,3,4,5,6,7,8,9};
		reverse(ary,7, 0);

	}
	static void reverse(int[] ary,int fromLast , int len)
	{
		//for loop till end
		if(len==ary.length)
		{
			reveCount=0;			
		}
		else{
			len++;
			reverse(ary,fromLast, len);
			reveCount++;
			if(reveCount==fromLast)
				System.out.println(ary[len-1]);
		}
		
	}

}
