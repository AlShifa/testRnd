package com.syne.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
	
	public static void main(String[] args) {
		
		MyClass first = new MyClass("a","first");
		MyClass second = new MyClass("a","second");
		/*HashMap<String, String> map= new HashMap<String, String>();
		map.put("1", "String1");
		map.put("2", "String2");
		map.put("3", "String3");
		map.put("4", "String4");		
		System.out.println(map.get("1"));*/
		//java.util.
		HashMapCustome<MyClass, String> map= new HashMapCustome<MyClass, String>();
		map.put(first,"check first");
		map.put(second,"check second");
		System.out.println(map.size());
		System.out.println(map.get(first));
		/*Set<Map.Entry<MyClass,String>> entrySet = map.entrySet();		 
		Iterator it = entrySet.iterator(); 
	    while (it.hasNext()) { 
	        Map.Entry pairs = (Map.Entry)it.next(); 
	        System.out.println(pairs.getKey() + " = " + pairs.getValue()); 
	        it.remove(); // avoids a ConcurrentModificationException 
	    } */

	}

}
