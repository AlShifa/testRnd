package com.ddlab.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class TestEmp {
	
	public static void main(String[] args) 	  {
		
		Emp emp1 = new Emp(23);	
		Emp emp2 = new Emp(24);		
		Emp emp3 = new Emp(25);
		Emp emp4 = new Emp(26);
		Emp emp5 = new Emp(27);
		
		//Emp emp6 = new Emp(25);
		
		HashSet<Emp> hs = new HashSet<Emp>();
		hs.add(emp1);
		hs.add(emp2);
		hs.add(emp3);
		hs.add(emp4);
		hs.add(emp5);
		
		System.out.println("HashSet Size--->>>"+hs.size());	
		//System.out.println("hs.contains( new Emp(25))--->>>"+hs.contains(new Emp(25)));
		System.out.println("hs.contains( emp6)--->>>"+hs.contains(new Emp(25)));		
		System.out.println("emp3 object :"+emp3 +"\nemp3 has code:"+emp3.hashCode());		
		/*System.out.println("emp3 identityHashCode: "+System.identityHashCode(emp3));
		System.out.println("\nemp6:"+emp6 +"\nemp6 has code:"+emp6.hashCode());
		System.out.println("emp6 identityHashCode: "+System.identityHashCode(emp6));
		System.out.println("[ emp3==emp6 ]" +(emp3==emp6) );
		System.out.println("emp7"+emp7);
		System.out.println("emp7.hashCode()"+emp7.hashCode());
		System.out.println("emp7.identityHashCode()"+System.identityHashCode(emp7));
		System.out.println("[ emp6==emp7 ]" +(emp6==emp7) );
		System.out.println("hs.remove( new Emp(24)--->>>"+hs.remove( new Emp(24)));	
		System.out.println("Now HashSet Size--->>>"+hs.size());		 
		*/ 
		int hashValue = TestEmp.hash(25);
		System.out.println(hashValue);
		
		ArrayList<Emp> aryEmp = new ArrayList<Emp>();
		ArrayList<Emp> aryEmp2 = new ArrayList<Emp>();
		ArrayList<Emp> aryEmp3 = new ArrayList<Emp>();
		aryEmp.add(new Emp(1));
		aryEmp.add(new Emp(2));
		aryEmp.add(new Emp(3));
		aryEmp.add(new Emp(4));
		aryEmp.add(new Emp(5));
		aryEmp2.add(new Emp(6));
		aryEmp2.add(new Emp(7));
		HashMap<String, ArrayList<Emp>> empRecords =  new HashMap<String, ArrayList<Emp>>();
		empRecords.put("1", aryEmp);
		empRecords.put("2", aryEmp2);
		Set ss = empRecords.entrySet();
		Iterator it = (Iterator)ss.iterator();
		while(it.hasNext())
		{
			Map.Entry me = (Map.Entry)it.next();
			System.out.print(me.getKey() + ": "); 
			System.out.println(me.getValue()); 
			empRecords.put("3",aryEmp3);		
		}
		//HashMap.KeyIterator hMapKeyIter = new HashIterator(); 
		
	}
	
	static int hash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

	
}
