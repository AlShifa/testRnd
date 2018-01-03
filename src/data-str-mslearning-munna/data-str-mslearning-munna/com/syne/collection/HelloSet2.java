package com.syne.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class HelloSet2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Collections.newSetFromMap(map)
		
		//ConcurrentHashMap<K, V>
		 ArrayList<Emp> ary = new ArrayList<Emp>();
		ary.add(new Emp(111, "abc", 888));
		ary.add(new Emp(101, "pqr", 786));
		ary.add(new Emp(87, "sss", 8880));
		ary.add(new Emp(7864, "xyuz", 9786));
		ary.add(new Emp(902, "uvw", 776));
		Collections.sort(ary);
		for (Emp eary : ary) {
			System.out.println("eary:" + eary);
		} 
		
		HashSet<Emp> set = new HashSet<Emp>();
		set.add(new Emp(111, "abc", 888));
		set.add(new Emp(101, "pqr", 786));
		set.add(new Emp(87, "sss", 8880));
		set.add(new Emp(7864, "xyuz", 9786));
		set.add(new Emp(902, "uvw", 776));

		// traversign set
		for (Emp s : set) {
			System.out.println(s);
		}
		
		TreeSet<Emp> tset = new TreeSet<Emp>(set);
		System.out.println("usign Iterator..after sorting....");
		Iterator<Emp> it = tset.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}	

		MyComparator mycomp = new MyComparator();
		int type = 1;// Integer.parseInt(JOptionPane.showInputDialog("Enter sorting type(1 for id, 2 for name"));
		mycomp.setSortType(type);
		TreeSet<Emp> tset1 = new TreeSet<Emp>(mycomp);		
		tset1.addAll(set);		
		Iterator<Emp> itt = tset1.iterator();
		while (itt.hasNext()) {
			System.out.println("hash set order"+itt.next());
		}		
		
		HashMap<Integer, Emp> hmap = new HashMap<Integer, Emp>();
		hmap.put(1, new Emp(111, "abc", 888));
		hmap.put(2, new Emp(101, "pqr", 786));
		hmap.put(3, new Emp(87, "sss", 8880));
		hmap.put(4, new Emp(7864, "xyuz", 9786));
		hmap.put(5, new Emp(902, "uvw", 776));
		Set<Map.Entry<Integer, Emp>> keySet = hmap.entrySet();		
		ArrayList as = new ArrayList(keySet); //size of array is five.		
		MyComparatorMapEntry mycomparator = new MyComparatorMapEntry() ;
		mycomparator.setSortType(2);
		Collections.sort(as,mycomparator);
		System.out.println(as);
		
		
		/* below are others alternative
		 * Collections.sort(as, new Comparator() {
			public int compare(Object o1, Object o2) {
				Map.Entry e1 = (Map.Entry) o1;
				Map.Entry e2 = (Map.Entry) o2;
				Emp first = (Emp) e1.getValue();
				Emp second = (Emp) e2.getValue();
				return first.compareTo(second);
			}
		});*/
	/*	Iterator i = as.iterator();
		while (i.hasNext()) {
			System.out.println((Map.Entry) i.next());
		}
		
		//second way 
		MyComparatorMapEntry mycomparator2 = new MyComparatorMapEntry() ;
		mycomparator2.setSortType(2);		
		TreeMap treemap = new TreeMap(mycomparator2);
		treemap.putAll(hmap);*/		
		
		
	
		
		
	}

}
