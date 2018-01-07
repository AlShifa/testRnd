package com.syne.thr;

public class RunableCls implements Runnable{
	final PrintStack pstack ;
	RunableCls(PrintStack pstack)
	{
		this.pstack = pstack;
	}
	public void run()
	{
		System.out.println("call push thread "+Thread.currentThread());
		int pus = 2008;				
		while (true) {
			pstack.push(pus);
			pus++;
			try{
				Thread.sleep(2000);
			}catch(Exception e)
			{
				new Exception(e);
			}
			
		}
		
	}

}
