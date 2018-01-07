package com.wells.core.thrd;

public class DeadLocakMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeadLocakMain dd = new DeadLocakMain();
		DeadLockSharedObjectt shaObj = new DeadLockSharedObjectt();
		MyThrd myThrd1 = dd.new MyThrd(shaObj,1);
		MyThrd myThrd2 = dd.new MyThrd(shaObj,2);	
		//Arrays.st

	}
	
	 class MyThrd implements Runnable
	{
		final DeadLockSharedObjectt  obj  ;
		MyThrd(DeadLockSharedObjectt  obj,int i)
		{
			this.obj = obj;
			Thread d = new Thread(this);
			d.setName(""+i);
			d.start();
		}
		
		public void run()
		{
			/*System.out.println("hello");
			if(Thread.currentThread().getName().equalsIgnoreCase("1"))
				try {
					obj.m1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(Thread.currentThread().getName().equalsIgnoreCase("2"))
				try {
					obj.m2();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			 while(true)
			 {
				 System.out.println("hello");
				 obj.m3();
			 }
			
		}
	}

}
