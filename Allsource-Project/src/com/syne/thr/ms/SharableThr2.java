package com.syne.thr.ms;

import java.util.Random;

public class SharableThr2 implements Runnable {
	
	//SharableCls cls = new SharableCls();	
	public void run() {
		
		for(int i = 0; i<=10 ;i++)
		{
			ClientSharable.clntShar.get(i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}	

}
