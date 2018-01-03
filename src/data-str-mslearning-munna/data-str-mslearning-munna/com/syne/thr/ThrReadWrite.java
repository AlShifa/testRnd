package com.syne.thr;

import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThrReadWrite extends Thread {

	// ExecutorService exServ = Executors.newFixedThreadPool(2);
	public static void main(String arg[]) {
		final StackImp stk = new StackImp(100);
		//Runnable rw1 = new ReaderWriter(stk);
		//Runnable rw2 = new ReaderWriter2(stk);       
		//Executor executor = Executors.newFixedThreadPool(2);
		//executor.execute(rw1);
		//executor.execute(rw2);
		
		ThrReadWrite thrd = new ThrReadWrite();
		thrd.m();
		//Thread thrd = new Thread(new ThrReadWrite());
		
		
		//String str =  UUID.randomUUID().toString();
		//System.out.print(str);
	}
	void m()
	{
		System.out.println(getState());
	}

}
