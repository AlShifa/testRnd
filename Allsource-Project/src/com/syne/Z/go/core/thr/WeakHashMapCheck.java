package com.syne.Z.go.core.thr;

import java.lang.ref.PhantomReference;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

import com.syne.collection.HashMapCustome;

public class WeakHashMapCheck {
	
	public static void main(String[] args) {
		
		/*HashSet<String> hset = new HashSet<String>();
		System.out.println(hset.add("1"));
		System.out.println(hset.add("1"));*/		
		
		/*HashMap<Employee, Employee> hmap = new HashMap<Employee, Employee>();
		hmap.put(emp, emp);
		System.out.println(hmap.get(emp).getName());		
		emp.setName("name");
		System.out.println(hmap.get(emp));
		*/
		
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("one");
		Employee emp2 = new Employee();
		emp2.setId(2);
		emp2.setName("two");
		
		Employee emp3 = new Employee();
		emp3.setId(3);
		emp3.setName("three");
		//HashMap<Employee, String> whkmap = new HashMap<Employee, String>();
		WeakHashMap<Employee, String> whkmap = new WeakHashMap<Employee, String>();
		whkmap.put(emp1, "One");
		whkmap.put(emp2, "two");
		whkmap.put(emp3, "three");
		emp1=null;
		emp2=null;		
		System.gc();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(whkmap.size());	
		
		
	}

}
