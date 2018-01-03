package com.syne.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class FailFastHMap {

	public static void main(String[] args) {

		//final HashMap<String, String> hmap = new HashMap<String, String>();
		//final Hashtable<String, String> hmap = new Hashtable<String, String>();
		//final ConcurrentHashMap<String, String> hmap = new ConcurrentHashMap<String, String>();
		
		//java.util.concurrent.CopyOnWriteArrayList<String>
		ArrayList<String>  ary = new ArrayList<String>();
		final Vector<String>  vary = new Vector<String>();
		//List<String> lst =  Arrays.asList("hello");
		//System.out.println(lst);
		
		
		FailFastHMap failFstMap = new FailFastHMap();
		/*hmap.put("one", "1");
		hmap.put("two", "2");
		hmap.put("three", "3");
		hmap.put("four", "4");
		hmap.put("five", "5");
		hmap.put("six", "6");
		hmap.put("seven", "7");
		hmap.put("eight", "8");
		hmap.put("nine", "9");
		hmap.put("ten", "10");*/
		vary.add("one");
		vary.add("two");
		vary.add("three");
		vary.add("four");
		vary.add("five");
		vary.add("six");

		(new Thread() {
			public void run() {
			//	Set s = hmap.keySet();
				while (true) {
					//Iterator iter = s.iterator();
					Iterator iter = vary.iterator();					
					while (iter.hasNext()) {
						System.out.println("size" + vary.size() + " "
								+ iter.next());
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}

			}
		}).start();

		(new Thread() {
			public void run() {
				try {

				/*	hmap.put("eleven", "11");
					hmap.put("twelve", "12");
					hmap.put("thirteen", "13");*/
					vary.add("seven");
					vary.add("eight");
					vary.add("nine");
					
					Thread.sleep(200);					
					/*hmap.put("fourteen", "14");
					hmap.put("fifteen", "15");
					hmap.put("sixteen", "16");*/
					vary.add("ten");
					vary.add("eleven");
					vary.add("twelve");
					vary.add("thirteen");
					

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

	}

}
