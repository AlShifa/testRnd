package com.coreJ;

import java.io.IOException;

public class CheckedException {
	
		CheckedException(Object obj)
	{System.out.println("object call");}
	CheckedException(StringBuffer[] arry)
	{
		System.out.println("array call");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckedException(null);
		//boolean od = doOdd(6);
		//System.out.println(od);

	}
	static boolean doOdd(int i)
	{
		String j ="1";
		while(j!=j+0){System.out.println("hi");}
		//return i%2==1;
		return false;
		
	}

}
