package com.syne.Z.go.core.thr;

import java.util.Random;

public class Producer implements Runnable {

	Random rdm = new Random();
	private final ShareObject shareObject;

	Producer(ShareObject shareObject) {
		this.shareObject = shareObject;

	}

	@Override
	public void run() {		
		while (true) {
			try {
				shareObject.setArryLst(rdm.nextInt());
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}

}
