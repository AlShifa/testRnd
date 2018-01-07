package com.syne.Z.go.core.thr;

import java.util.LinkedHashMap;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.DelayQueue;



public class DemoThread {
	static ShareObject sharObject ;
	public static void main(String[] args) throws InterruptedException {	
		
		int size = 10;
		sharObject = new ShareObject(size);	
		
		//Producer
		Producer ThrObj2= new Producer(sharObject);
		Thread th2 = new Thread(ThrObj2);
		th2.start();		
		
		//Consumer
		Consumer ThrObj1 = new Consumer(sharObject);		
		Thread th1 = new Thread(ThrObj1);			
		th1.start();	
		

	}

}
