package com.syne.collection.linkHM;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Queue;
import java.util.TreeSet;

import com.syne.concurrent.collection.ArrayList;

class LinkedHashMapEx1 {
	public static void main(String[] args) {

		LinkedHashMap map = new LinkedHashMap(12, 1.0f, false)
		{
			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry eldest) {
				// TODO Auto-generated method stub
				System.out.println("size"+size());
				System.out.print("hello");
				return (size() > 12);
				//System.out.println(eldest);
				//return super.removeEldestEntry(eldest);
			}
		};// Add some	
		
		//map.
		
		//map.put("S", "dataElement-1");
		map.put("K", "dataElement-2");
		map.put("C", "dataElement-3");
		map.put("B", "dataElement-4");
		//System.out.println(map.size());
		
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
		Object key = it.next();
		System.out.println("Key = " + key.toString());
		}
		/*HashMap mapp = new HashMap(2, 0.1f);// Add some elements
		mapp.put("S", "dataElement-1");
		mapp.put("K", "dataElement-2");
		mapp.put("C", "dataElement-3");
		mapp.put("B", "dataElement-4");*/
		
		//System.out.println(map.size());
		// List the entries
		

		/*System.out.println(mapp.size());
		for (Iterator it = mapp.keySet().iterator(); it.hasNext();) {
			Object key = it.next();
			System.out.println("Key = " + key.toString());
		}*/
		//ArrayList<Object> ary = new ArrayList<String>();		
		//Queue q = new Queue();
		

	}
}
