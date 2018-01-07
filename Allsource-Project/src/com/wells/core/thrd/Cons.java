package com.wells.core.thrd;

public class Cons implements Runnable {

	final SharedObjectt obj;
	
	Cons(SharedObjectt obj)
	{
		this.obj=obj;
		
	}

	@Override
	public void run() {
		
			int i=0;
			while(true)
			{
				obj.getValue(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;
				
			}

	}
}
