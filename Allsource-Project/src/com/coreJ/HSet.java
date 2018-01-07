package com.coreJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class HSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Integer i1 = new Integer(1);
		
		Employee emp1 = new Employee(1,"A","bana");
		Employee emp2 = new Employee(2,"B","aara");
		Employee emp3 = new Employee(3,"C","gya");
		
		HashSet<Employee> hset = new HashSet<Employee>();
		hset.add(emp1);
		hset.add(emp2);
		hset.add(emp3);
		
		ArrayList list = new ArrayList(hset);
		Collections.sort(list);
		System.out.println(list);
		
		ArrayList<Employee> list2 = new ArrayList<Employee>(hset);
		for(Employee e : list2)
			System.out.print(e);
			
		
		
		System.out.println("\n");
		HashSet<String> hset1 = new HashSet<String>();
		hset1.add("one");
		hset1.add("two");
		hset1.add("one");
		System.out.println(hset1.size()+"[]"+hset1.add("three"));
		
		
		HashMap<String,String> hmap1 = new HashMap<String,String>();
		hmap1.put("one","1");
		hmap1.put("two","2");
		hmap1.put("one","5");
		System.out.println(hset1.size()+"[]"+hmap1.put("one","4"));
		
		
		
		Map<Integer, String> asciiMap = new HashMap<Integer,String>();
		asciiMap.put(65, "A");
		asciiMap.put(66, "B");
		asciiMap.put(67, "C");
		asciiMap.put(68, "D");
		System.out.println(asciiMap);
		
		
		

	}

}
 