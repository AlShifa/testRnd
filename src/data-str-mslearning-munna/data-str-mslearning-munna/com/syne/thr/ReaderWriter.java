package com.syne.thr;

import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReaderWriter implements Runnable {
	int i =1;
	StackImp stk = null;
	public ReaderWriter(final StackImp stack)
	{
		stk = stack;
	}
	
	Lock lock = new ReentrantLock();
	public void run()
	{	int i = 100;	
		while(i>0)
		{
			i--;
			try{
				lock.lock();
				Object randomValue =  UUID.randomUUID();
				//System.out.println("Push Locked ");
				System.out.println("[call push]:"+randomValue);
				stk.push(randomValue);
				//Thread.sleep(2000);      
			}catch(Exception e)
			{
				
			}finally{
				//System.out.println("Push Lock Release ");
				lock.unlock();	
			}/*try{
				lock.lock();				
				Object obj = stk.pop();
				System.out.println("[call pop ]:"+obj);
			}finally{
				lock.unlock();	
			}*/
			
			
			
		}
	}
	
	

}
