package com.syne.thr;

public class TheThrd {

	public static void main(String art[])throws Exception {
		final PrintStack pstack = new PrintStack();
		
		(new Thread("pop") {
			public void run() {				
				while(true){
				pstack.pop();				
				try{
					Thread.sleep(20000);
					}catch(Exception e)
					{
						
					}
			}
			}
		}).start();
		
		(new Thread("push") {
			public void run() {
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

		}).start();

	}

}
