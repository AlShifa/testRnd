package com.syne.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class FailFastArrayLst {

	public static void main(String[] args) {

		//final HashMap<String, String> hmap = new HashMap<String, String>();
		final ConcurrentHashMap<String, String> hmap = new ConcurrentHashMap<String, String>();
		
		//java.util.concurrent.CopyOnWriteArrayList<String>
	//	final ArrayList<String>  ary = new ArrayList<String>();
		final CopyOnWriteArrayList<String>  ary = new CopyOnWriteArrayList<String>();
		ary.add("one");
		ary.add("two");
		ary.add("three");
		ary.add("four");
		ary.add("five");
		ary.add("six");
		ary.add("seven");
		
		

		(new Thread() {
			public void run() {
				//Set s = ary.keySet();
				while (true) {
					//Iterator iter = ary.iterator();
					//while (iter.hasNext()) {						
						//System.out.println("size" + ary.size() + " "+ iter.next());	
					ary.add("one");
					ary.add("two");
					ary.add("three");
					ary.add("four");
					try {
					ary.add("five");
					ary.add("six");
					ary.add("seven");
						System.out.println("array size 11111111 "+ary.size());
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					//}

				}

			}
		}).start();

		(new Thread() {
			public void run() {
				try {
					while (true) {
					ary.add("eight");
					ary.add("nine");
					ary.add("ten");
					Thread.sleep(200);					
					ary.add("eleven");
					ary.add("tweleve");
					ary.add("thirteen");
					System.out.println("array size 2222222222222 "+ary.size());
					
				}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

	}

}
