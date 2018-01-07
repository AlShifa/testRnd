package com.wells.core.thrd;

public class MyThrd extends Thread {
	
	MyThrd()
	{
		start();
		//setName("A");
	}
	
	public void run()
	{
		while(true)
		{
			
		if(Thread.currentThread().getName().equals("Manazir1"))
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("call run for Manazir 1 Thread ");
		}
		else
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("call run for Manazir 2 Thread ");
		}
		}
	}

}
