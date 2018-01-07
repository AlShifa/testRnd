package com.thrd;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class ThreadTwoLatch implements Runnable {

	Thread t ;
	final CountDownLatch obj;
	CountShrdObj cnt;
	ThreadTwoLatch(String name, CountDownLatch obj,CountShrdObj cnt)
	{	
		this.obj = obj;
		this.cnt=cnt;
		t= new Thread(this);
		t.start();
		t.setName(name);	
		
	}

	@Override
	public void run() {
		
		System.out.println("Thread START"+ Thread.currentThread().getName());
		cnt.count++;
		
		try {
			//while(true){
			obj.countDown();
			//obj.reset();	
			/*System.out.println("Thread END"+ Thread.currentThread().getName());
			cnt.count--;
			obj.await();*/
			//}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 


	}
}
