package munna.thr;

import java.util.Random;

public class ThreadPrintTwoNumber {
	static SharedObject share1 = new SharedObject();
	public static void main(String[] args) throws InterruptedException {		
		for (int i = 1; i <3; i++) {
			new MyRunnable(share1,i);
		}
	}

	private static class MyRunnable implements Runnable {
		SharedObject share =null;
		Thread t1;

		MyRunnable(SharedObject share,int i) throws InterruptedException {
			 this.share = share;
			t1 = new Thread(this);
			t1.setName(""+i);
			t1.start();		
		}

		@Override
		public void run() {
			while (true) {
				try {
					share.setValue();
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}
}