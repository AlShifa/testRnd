package com.syne.thr.ms;

import java.util.Random;

public class SharableThr1 implements Runnable {
	
	SharableCls cls = new SharableCls();
	Random randomGenerator = new Random();	
	@Override
	public void run() {
		
		for(int i = 0; i<=10 ;i++)
		{			
			long element = randomGenerator.nextLong();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ClientSharable.clntShar.put(element);
			
			
		}
		
	}

}
