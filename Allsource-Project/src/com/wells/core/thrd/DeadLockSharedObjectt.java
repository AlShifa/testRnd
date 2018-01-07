package com.wells.core.thrd;

import java.util.ArrayList;

public class DeadLockSharedObjectt {

	 ArrayList<Integer> x = new ArrayList<Integer>();
	 Object obj1 = new Object();
	 Object obj2 = new Object();

	synchronized void setValue(int i) {
		try {
			if (x.size() == 9999)
				wait();
			else {
				x.add(i);
				System.out.println(Thread.currentThread()+"[ pp ]"+i);
				notify();
				wait();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	synchronized void getValue(int i)
	{
		
		try{
			if(x.size()==0)
			{
				wait();
			}else{
				int y =  x.get(i);
				System.out.println(Thread.currentThread()+"[ cc ]"+y);
				notify();
				wait();
			}
			
			
		}catch(Exception ex){}
	}
	
	/* void m1() throws InterruptedException
	{
		 synchronized (obj1) {
				Thread.sleep(1000);
				System.out.println("after Sleep m1() "+Thread.currentThread().getName());
				synchronized (obj2) {
					System.out.println("inside object2");
				}
				
			
		}
	
	}
	 void m2() throws InterruptedException
	{
		 synchronized (obj2) {
				Thread.sleep(1000);
				System.out.println("after Sleep m1() "+Thread.currentThread().getName());
				synchronized (obj1) {
					System.out.println("inside object2");
				}
				
			
		}
	}
	 */
	synchronized void m3()
	{
		if(Thread.currentThread().getName().equals("1"))
			try {
				System.out.println(Thread.currentThread().getName());
				Thread.currentThread().join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(Thread.currentThread().getName().equals("2"))
			try {
				System.out.println(Thread.currentThread().getName());
				Thread.currentThread().join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
}
