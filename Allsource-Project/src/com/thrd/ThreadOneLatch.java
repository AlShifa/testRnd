package com.thrd;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class ThreadOneLatch implements Runnable {

	Thread t;
	final CountDownLatch obj;
	CountShrdObj cnt;

	ThreadOneLatch(String name, CountDownLatch obj,CountShrdObj cnt) {
		this.obj = obj;
		this.cnt=cnt;
		t = new Thread(this);
		t.start();
		t.setName(name);

	}

	@Override
	public void run() {

		try {
			//while(true){			
			System.out.println("Thread START"+ Thread.currentThread().getName());
			cnt.count++;
			obj.countDown();				
			//System.out.println("Thread END"+ Thread.currentThread().getName());
			//cnt.count--;
			//obj.await();
			//}
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
