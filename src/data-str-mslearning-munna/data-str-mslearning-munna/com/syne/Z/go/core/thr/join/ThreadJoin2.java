package com.syne.Z.go.core.thr.join;

public class ThreadJoin2 extends Thread{
	
	ThreadJoin1 t1;
	public ThreadJoin2()
	{
		super("ThreadJoin2");
		//System.out.println("[th1]"+th1);
		//t1=th1;
		
	}
	public void run() {		
		
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName()+"["+i+"]");
			/*try {
				
				Thread.sleep(0);
				System.out.println(Thread.currentThread().getName()+"["+i+"]");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			
		}
		
	}
	void setThreadJoin2(ThreadJoin1 t1)
	{
		t1 = t1;
	}

}
