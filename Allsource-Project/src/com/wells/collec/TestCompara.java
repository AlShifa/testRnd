package com.wells.collec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeSet;

public class TestCompara {
	
	public static void main(String[] args) {
		ArrayList<Employee> ary = new ArrayList<Employee>();
		//ArrayList ary = new ArrayList();
		Employee e1 = new Employee(10, "ten");
		Employee e2 = new Employee(3, "three");
		Employee e3 = new Employee(14, "fort14");
		Employee e4 = new Employee(2, "two");
		ary.add(e1);
		ary.add(e2);
		ary.add(e3);
		ary.add(e4);		
		//Collections.sort(ary);
		//for(Employee e : ary)
			//System.out.println(e);
		//HashMap<Employee, Integer> hmap = new HashMap<Employee, Integer>();
		HashSet<Employee> hset = new HashSet<Employee>();
		hset.add(e1);
		hset.add(e2);
		hset.add(e3);
		hset.add(e4);
		System.out.println(hset);
		ArrayList<Employee> ary2 = new ArrayList<Employee>(hset);
		Collections.sort(ary2);
	/*	for(Employee e : ary2)
			System.out.println(e);
		*/System.out.println("\n");
		TreeSet<Employee> tset = new TreeSet<Employee>(hset);
	
		/*for(Employee e : tset)
			System.out.println(e);
*/		//System.out.println("\n");
		HashMap<Employee, Integer> hmap = new HashMap<Employee, Integer>();
		hmap.put(e1, 1);
		hmap.put(e2, 2);
		hmap.put(e3, 3);
		hmap.put(e4, 4);
		Set<Map.Entry<Employee, Integer>>  entrySet = hmap.entrySet();
		for(Map.Entry<Employee, Integer> e : entrySet)
			System.out.println(e.getKey());
		
		System.out.println("\n");
		TreeMap<Employee, Integer> treeMap = new TreeMap<Employee, Integer>(hmap);
		Set<Map.Entry<Employee, Integer>> entryMap = treeMap.entrySet();
		for(Map.Entry<Employee, Integer> e : entryMap)
			System.out.println(e.getKey());
		
		
		
		
		
	}

}
