package com.coreJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;


public  class A {
	
	  int x=20;//x=10;
	public static final void main(String[] args) {
		
		 A a = new A();
		 a.x=20;
		 //Error
		 List c =  Arrays.asList(new Integer[]{1,2,3});
		 System.out.println(c.getClass());
		 ArrayList<String> arryLst = new ArrayList<String>();
		 arryLst.add("one");
		 arryLst.add("two");
		 arryLst.add("three");
		//System.out.println(arryLst.remove(0));
		 //vt.elements();
		 Iterator it =  arryLst.iterator(); 
		 while(it.hasNext())
		 {
			 System.out.println(it.next());
			 //arryLst.remove(0);
		 }
		 
		 String str = "abcdefabcefgabch";
		 String[] strarray = str.split("abc");
		 System.out.println(strarray.length);
		 for(String str1 : strarray)
			 System.out.println(str1);
		// System.out.println(arryLst);
		 
		// ConcurrentHashMap<K, V>
		 
		 
	}

}
