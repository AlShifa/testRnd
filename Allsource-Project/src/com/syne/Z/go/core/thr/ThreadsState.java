package com.syne.Z.go.core.thr;

public class ThreadsState {
	
	 int value = 0;
	
	public static void main(String[] args) {
		
		final ThreadsState thstate = new ThreadsState();
		
		
final Thread t2 = new Thread(){	
			
			public void run()
			{
								
				System.out.println(thstate.get());
			}
			public void start()
			{
				
				super.start();
			}
		};
		System.out.println("[ current status of t2 ]"+t2.getState());
		t2.setName("t2 get");
		t2.start();
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		final Thread t1 = new Thread(){
			public void run()
			{
				try {
					
					for (int i = 0; i < 10; i++) {
						Thread.sleep(20);
						thstate.set(i);					
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		System.out.println("t1 set state "+t1.getState());
		t1.setName("t1 set ");
		t1.start();	
		
final Thread t3 = new Thread(){
			
			public void run()
			{
				for (int i = 0; i < 10000; i++) {
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("[ t1 set status ]"+t1.getState()+"[ t2 get status]"+t2.getState());
				}
			}
			
		};
		t3.start();
		
	}
	

	
	synchronized void set(int value)
	{
		
		this.value=value;
		notify();		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	synchronized int get()
	{
		System.out.println(Thread.currentThread().getName()+"------before wait-------"+Thread.currentThread().getState());
		while(value==0)
		{
			try {
				wait();
				Thread.sleep(300);
				System.out.println("[ "+Thread.currentThread().getName()+"]------after wait-------"+Thread.currentThread().getState());				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return value;
		
	}

}
