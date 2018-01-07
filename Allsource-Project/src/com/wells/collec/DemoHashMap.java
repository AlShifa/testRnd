package com.wells.collec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class DemoHashMap {
	
	public static void main(String[] args) {
		
		HashMap<String,String> hmap = new HashMap<String,String>();
		hmap.put("k1", "v1");
		hmap.put("k2", "v2");		
		Set<Entry<String,String>> entSet =  hmap.entrySet();
		Iterator<Entry<String,String>> it = entSet.iterator();	
		while(it.hasNext())
		{
			Entry<String,String> ent = it.next();
			System.out.println(ent.getKey());
			System.out.println(ent.getValue());
			//System.out.println(it.next());
			hmap.put("k3", "v3");
		}
		System.out.println(it.getClass());
		
		ArrayList<String> ary = new ArrayList<String>();
		Iterator<String> itary = ary.iterator();
		System.out.println(itary.getClass());
		
		LinkedList<String> linkLst = new LinkedList<String>();
		Iterator<String> itLnk = linkLst.iterator();
		System.out.println(itLnk.getClass());
		
		Set<String> st = new HashSet<String>();
		Iterator<String> itset = st.iterator();
		System.out.println(itset.getClass());
		
	}

}
 