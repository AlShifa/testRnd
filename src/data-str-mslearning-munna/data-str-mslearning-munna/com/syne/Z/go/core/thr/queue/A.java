package com.syne.Z.go.core.thr.queue;

import java.util.ArrayList;

public class A {	
	
	 ArrayList<String> aryLst = new ArrayList<String>();
	ArrayList<String> aryStr = new ArrayList<String>();
	
	Object   m()
	{
		return null;
	}
	public static void main(String[] args) {
		
		A a = new A();
		a.aryLst.add("hello");
		a.aryLst.add("two");
		System.out.println(a.aryLst);		
		synchronized(a.aryLst)
		{
			a.aryLst = null;
			
		}
	}
}
