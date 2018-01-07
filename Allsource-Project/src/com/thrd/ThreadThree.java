package com.thrd;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadThree implements Runnable {

	Thread t;
	final CyclicBarrier obj;
	CountShrdObj cnt;

	ThreadThree(String name, CyclicBarrier obj, CountShrdObj cnt) {
		this.obj = obj;
		this.cnt = cnt;
		t = new Thread(this);
		t.start();
		t.setName(name);
		
	}

	@Override
	public void run() {

		try {
			// while(true){
			System.out.println("Thread START"+ Thread.currentThread().getName());
			cnt.count++;
			obj.await();
			obj.reset();
			System.out.println("Thread END" + Thread.currentThread().getName());
			cnt.count--;
			obj.await();
			// }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
