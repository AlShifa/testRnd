package com.thrd;

import java.util.concurrent.CountDownLatch;

public class CountDownThrd implements Runnable {

	Thread t;
	CountDownLatch countDownLatch;
	CountShrdObj cnt;
	CountDownThrd(CountDownLatch countDownLatch,String name,CountShrdObj cnt)
	{
		t= new Thread(this);
		t.start();
		t.setName(name);
		this.countDownLatch = countDownLatch;
		this.cnt = cnt;
		
		
	}
	@Override
	public void run() {
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println(" GOOd GUYS GOOD JOB "+cnt.count);
		// TODO Auto-generated method stub

	}

}
