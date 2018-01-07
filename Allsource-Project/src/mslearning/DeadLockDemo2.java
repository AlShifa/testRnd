package mslearning;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockDemo2 {
	public static void main(String[] args) {

		final Object o1 = new Object();
		final Object o2 = new Object();

		Thread t1 = new Thread() {

			public void run() {
				synchronized (o1) {
					System.out.println("t1 has occupied the monitor of o1");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					synchronized (o2) {
						System.out.println("t1 has occupied the monitor of o2");

					}
				}
			}

		};

		Thread t2 = new Thread() {

			public void run() {
				synchronized (o2) {
					System.out.println("t2 has occupied the monitor of o2");

					synchronized (o1) {
						System.out.println("t2 has occupied the monitor of o1");

					}
				}
			}

		};

		t1.start();
		t2.start();

	}

}

