package com.syne.thr.ms;

public class ClientSharable {
	
	public static final SharableCls clntShar = new SharableCls();
	
	public static void main(String[] args) {
		Thread th1 = new Thread(new SharableThr1());
		th1.start();
		Thread th2 = new Thread(new SharableThr2());
		th2.start();
	}

}
