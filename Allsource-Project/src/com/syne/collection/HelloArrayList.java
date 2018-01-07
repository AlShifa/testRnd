package com.syne.collection;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class HelloArrayList {
	
	public static void main(String[] args) {
		
	
		HashMapCustome<String ,String> hs = new HashMapCustome<String, String>();
		hs.put("one", "1");
		hs.put("two", "2");
		hs.put("three", "3");
		//hs.put("one", "4");
		//hs.put("four", "4");
		//hs=null;
	  System.out.println(hs.get("one"));
	  System.out.println(hs.get("two")); 
	  System.out.println(hs.get("three"));
	  ArrayList ary = new ArrayList();
	 // Lin ary1 = new LinkedArray();
	  java.util.LinkedList ary1 = new LinkedList();	  
	  Hashtable hsa = new Hashtable();
		
		
	}

}
