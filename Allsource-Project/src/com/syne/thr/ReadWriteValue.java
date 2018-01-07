package com.syne.thr;

public class ReadWriteValue {
	 volatile int value = -1;

	// boolean readWrite = false;

	synchronized void setValue(int value) {

		this.value = value;
		System.out.println("--------setValue ----------" + value);
		try {
			Thread.sleep(200);
			System.out.println("--------setValue-after---------" + value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//notify();
	}

	synchronized int getValue() {
		if (value == -1) {
			//try {
				System.out.println("---Calling wait() invalid value---");				
				//wait();				
			/*} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		} else {
			System.out.println("Calling notify getValue" + value);
			//notify();			

		}
		return value;

	}
	public void callThr(int value)
	{
		try {
			Thread.sleep(200);
			System.out.println("------callThr ----after----"+value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
