package com.syne.core;

import java.util.ArrayList;
import java.util.List;

public class TestClass {
	
	
	
	public static void main(String[] arg) {
		
		TestClass ts = new TestClass();
		
		ts= null;
		
		A a= new A();
		A a2= new A();
		A a3=new A();
		List<A> list= new ArrayList<A>();
		list.add(a);
		list.add(a2);
		list.add(a3);
		list=null;
		
		System.gc();
	}
	protected void finalize() throws Throwable { 
		TestClass ts1 = new TestClass();
		System.out.println(ts1);
		ts1=null;
		System.gc();
		System.out.println("in finalize "+Thread.currentThread().getName());
		int i =10/0;
		
	}
}
