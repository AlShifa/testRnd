package com.wells.core.thrd;

public class RunThrd implements Runnable {

	public void run()
	{
		while(true)
		{
			
		if(Thread.currentThread().getName().equals("Manazir1"))
		{
			System.out.println("call run for Manazir 1 Thread ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		else if(Thread.currentThread().getName().equals("Manazir2"))
		{
			System.out.println("call run for Manazir 2 Thread ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		else if(Thread.currentThread().getName().equals("Manazir3"))
		{
			System.out.println("call run for Manazir 3 Thread ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		}//true

	}

}
