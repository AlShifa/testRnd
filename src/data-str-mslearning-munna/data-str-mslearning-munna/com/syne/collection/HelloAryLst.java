package com.syne.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;



public class HelloAryLst {
	
	public static void main(String[] args) {
		
		ArrayList<String> ary = new ArrayList<String>();
		ary.add("one");
		ary.add("two");
		ary.add("three");
		
		for(String s : ary)		
			System.out.println(s);
		
		Collections.sort(ary);
		
		for(String s : ary)		
			System.out.println(s);
		
		Emp emp = new Emp();
		emp.setEmpId(1);
		emp.setEmpName("manazir");
		emp.setSalary(10);
		HashSet<Emp> hs = new HashSet<Emp>();
		//Hashtable hsss = new Hashtable<String, String>();
		HashMap<Emp,String> hs22 = new HashMap<Emp,String>();
		Hashtable<String, String> hs23 = new Hashtable<String, String>();
		//hsss.add(emp);
		for(Emp e :hs)
		{
			System.out.println(e.getEmpId());
			System.out.println(e.getEmpName());
			System.out.println(e.getSalary());
			
		}	
		Integer i1 = new Integer(10);
		double i2 =10.1;
		//i1 = i2;
		//i2=i1;
		Hashtable<String, String> ht = new Hashtable<String, String>();
		String srt = "";
		Object obj = new Object();
		
		
	}

}
