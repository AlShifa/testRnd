package com.syne.Z.go.core.thr;

public class Consumer implements Runnable {

	private final ShareObject shareObject;

	Consumer(ShareObject shareObject) {
		this.shareObject = shareObject;
	}

	public void run() {		
		while (true) {
			try {
				shareObject.getArryLst();
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}

}
