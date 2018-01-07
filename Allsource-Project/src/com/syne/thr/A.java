package com.syne.thr;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class A {
	
	Integer it = new Integer(25);
	static final int k =10;

	public static void main(String[] args) {
		
		Thread th = Thread.currentThread();
		Map map = th.getAllStackTraces();
		Collection c = map.values();
		StackTraceElement[] st = th.getStackTrace();	
		
		Iterator itr = c.iterator();
		while(itr.hasNext())
		{
			StackTraceElement[] straceElem = (StackTraceElement[])itr.next();
		     System.out.println(straceElem.length);
		     for(StackTraceElement str :straceElem )
		     {
		    	 System.out.println(str.toString());
		    	 //System.out.println(str.getClassName());
		     }
		}

	}

}
