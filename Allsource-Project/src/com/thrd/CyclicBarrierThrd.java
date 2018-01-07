package com.thrd;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThrd implements Runnable {
	
	CountShrdObj cnt;
	public CyclicBarrierThrd(String barrier,CountShrdObj cnt ) {
		this.cnt=cnt;
	}

	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println(" ************BARRIER DON'T CROSS******check count******"+cnt.count);

	}

}
