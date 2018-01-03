package com.syne.thr;

import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReaderWriter2 implements Runnable {
	int i =1;	
	StackImp stk = null;
	public ReaderWriter2(final StackImp stack)
	{
		stk = stack;
	}
	Lock lock = new ReentrantLock();
	public void run()
	{	int i = 100;	
		while(i>0)
		{
			i--;
			/*try{
				lock.lock();
				Object randomValue =  UUID.randomUUID();
				System.out.println("[call push]:"+randomValue);
				stk.push(randomValue);
			}finally{
				lock.unlock();	
			}*/try{
				lock.lock();				
				Object obj = stk.pop();
				System.out.println("[call pop ]:"+obj);
				Thread.sleep(200);
			}catch(Exception e)
			{
				
			}finally{
				lock.unlock();	
			}
			
			
			
		}
	}
	
	

}
