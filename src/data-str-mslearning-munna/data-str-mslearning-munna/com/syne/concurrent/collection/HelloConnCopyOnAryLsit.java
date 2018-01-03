package com.syne.concurrent.collection;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
//import java.util.concurrent.CopyOnWriteArrayList;

public class HelloConnCopyOnAryLsit {

	public static void main(String[] args) throws Exception {

		final CopyOnWriteArrayList<String> ary = new CopyOnWriteArrayList<String>();
		// final ArrayList<String> ary = new ArrayList<String>();
		ary.add("one");
		ary.add("two");
		ary.add("three");
		ary.add("four");

		(new Thread() {
			public void run() {
				// Set s = ary.keySet();
				//while (true) {
					Iterator iter = ary.iterator();
					while (iter.hasNext()) {
						try {

							System.out.println("size of array]"+ary.size()+" "+iter.next());
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
							try {
								throw new Exception(e);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					}

				//}

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
						System.out.println("array size 2222222222222 "
								+ ary.size());

					}

				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

	}

}
