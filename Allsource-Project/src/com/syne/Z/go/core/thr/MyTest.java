package com.syne.Z.go.core.thr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import com.syne.collection.HashMapCustome;


public class MyTest {
	
	ArrayList<String> aryLst = new ArrayList<String>();
	public static void main(String[] args) {
		MyTest myTest = new MyTest();
		myTest.aryLst.add("one");
		myTest.aryLst.add("two");
		myTest.aryLst.add("three");		
		myTest.aryLst.remove(0);		
		Collections.unmodifiableList(myTest.aryLst);
		//String str = new String("test");
		String str = "one two one three four five six one one six three five one two five three nine eight seven six five four";
		String[] strSplit =  str.split("\\s");
		HashMapCustome<String, Integer> hMap = new HashMapCustome<String, Integer>();
		/*ArrayList<String> aryLst = new ArrayList<String>(Arrays.<String>asList(strSplit));
		ArrayList<String> aryLst1 = new ArrayList<String>();		
		//HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		LinkedList<String> lnkedLst = new LinkedList<String>();
		String finalStr = "";
		for(String arstr : aryLst )
		{
			if(!aryLst1.contains(arstr))
			{
				Integer i = Collections.frequency(aryLst,arstr );	
				aryLst1.add(arstr);
				hMap.put(arstr, i);
				//lnkedLst.add(arstr);				
			}			
		}*/
		hMap = new HashMapCustome<String, Integer>();		
		int x =1;
		int i =0;
		for(String str1 =strSplit[i]; i<strSplit.length;i++)
		{
			System.out.println(hMap.containsKey(str1));
			if(hMap.containsKey(str1));
			{
				System.out.println("contain");
			}
			hMap.put(str1, x);
			System.out.println(str1);
			i++;
		}
		
		
		Set mapEntry = hMap.entrySet();		
		ArrayList<Map.Entry<String, Integer>> as = new ArrayList<Map.Entry<String, Integer>>(mapEntry);
		
	/*	Collections.sort(as, new Comparator() {
			public int compare(Object o1, Object o2) {
				Map.Entry e1 = (Map.Entry) o1;
				Map.Entry e2 = (Map.Entry) o2;
				Integer first = (Integer) e1.getValue();
				Integer second = (Integer) e2.getValue();				
				return first.compareTo(second);
			}
		});*/
		Collections.sort(as, new Comparator() {
			public int compare(Object o1, Object o2) {
				Map.Entry e1 = (Map.Entry) o1;
				Map.Entry e2 = (Map.Entry) o2;
				Integer first = (Integer) e1.getValue();
				Integer second = (Integer) e2.getValue();
				if(first.equals(second))
					return ((String)e1.getKey()).compareTo((String)e2.getKey());
				else return first.compareTo(second);
			}
		});
		
		
	}

}
