package com.syne.thr;


import java.util.ArrayList;
import java.util.LinkedList;

public class Collect {	
	
	static ArrayList<Integer> ary1 = new ArrayList<Integer>();
	 
	public static void main(String[] args) {		
		
		
		/*Object obj2 = null;
		Object obj3 = new Object();
		if ( obj3 instanceof Object ) {
			//if ( obj2 instanceof Object )
			//if ( null instanceof Object ) {
			
			System.out.println("-----111-----");
			
		}else
		{
			System.out.println("-----222-----");
		}
		*/
		Collect coll= new Collect();
		//System.out.println(coll);
		//System.out.println(coll.hashCode());
		
		//int i =10;
		long i =3;
		Integer i2 = new Integer(10);
		coll.m(2);
		coll.m(i);
		coll.m(i2);
		
		
	}
	void m(int a)
	{
		System.out.println("[["+a);
				
	}
	void m(long a)
	{
		System.out.println(a);
				
	}/*void m(Integer a)
	{
		System.out.println(a);
				
	}*/
	
	

}
