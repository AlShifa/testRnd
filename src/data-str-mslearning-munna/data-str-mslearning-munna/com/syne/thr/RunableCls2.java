package com.syne.thr;

public class RunableCls2 implements Runnable{
	final PrintStack pstack ;
	RunableCls2(PrintStack pstack)
	{
		this.pstack = pstack;
	}
	public void run()
	{
		System.out.println("call pop Thread"+Thread.currentThread());
		while(true){
			pstack.pop();				
			try{
				Thread.sleep(20000);
				}catch(Exception e)
				{
					
				}
		}
		
	}

}
