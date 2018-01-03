package com.syne.Z.go.core.thr.join;

public class ThreadJoin1 extends  Thread {
	
	ThreadJoin2 t2;
	public ThreadJoin1()
	{
		super("ThreadJoin1");		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 20; i++) {			
			try {
				
				System.out.println(Thread.currentThread().getName()+"["+i+"]");
				Thread.sleep(10);				
				if(i>10)
				{
					System.out.println("inside yield");
					//t2.join();
					Thread.currentThread().yield();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
		
	}
	void setThreadJoin1(ThreadJoin2 th2)
	{
		t2=th2;
	}
	
	

}
