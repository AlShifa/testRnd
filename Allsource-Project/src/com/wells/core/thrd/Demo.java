package com.wells.core.thrd;

import java.util.concurrent.ConcurrentHashMap;

public class Demo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SharedObjectt obj = new SharedObjectt();
		Thread t1 = new Thread(new Prod(obj),"Producer");
		t1.start();
		t1.sleep(100);
		Thread t2 = new Thread(new Cons(obj),"Consumer");
		t2.start();
		t2.sleep(100);
		//HashMap<String,String> map = new HashMap<String,String>();
		//ConcurrentHashMap<K, V>

	}

}
