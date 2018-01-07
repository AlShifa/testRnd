package com.syne.thr;

import java.util.concurrent.atomic.AtomicInteger;

public class Count {
	
	//volatile int  cnt =9;
	
	AtomicInteger cnt = new AtomicInteger(0); 
	
	void setCount()
	{
		//cnt++;
		cnt.getAndIncrement();		
		
		System.out.println("[cnt value ]"+cnt.get()+"[::]"+Thread.currentThread().getName());
		
		
		
	}

}
