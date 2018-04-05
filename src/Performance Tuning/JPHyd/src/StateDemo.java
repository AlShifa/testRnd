import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StateDemo {

	public static void main(String[] args) throws Exception {

		final BlockingQueue<String> bq = new ArrayBlockingQueue<String>(3, true);
		bq.put("s1");
		bq.put("s2");
		bq.put("s3");

		System.out.println("fter 3 puts");
		new Thread() {
			public void run() {
				try {
					Thread.sleep(3000);
					bq.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}.start();
		bq.put("s4");
		System.out.println("After 4th put");

		if (true) {
			return;
		}

		final MyInteger myInt = new MyInteger();

		final Thread t1 = new Thread() {
			public void run() {
				myInt.setValue();
			}

		};
		final Thread t2 = new Thread() {
			public void run() {
				myInt.getValue();
			}
		};

		t1.start();
		t2.start();

		new Thread() {
			public void run() {

				while (true) {
					System.out.println("state of t1 : " + t1.getState().name()
							+ " -- state of t2 " + t2.getState().name());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		}.start();

	}

}

class MyInteger {

	Lock lock = new ReentrantLock();
	ReadWriteLock lockRW = new ReentrantReadWriteLock();
	Lock readLock = lockRW.readLock();
	Lock writeLock = lockRW.writeLock();

	public void getValue() {

		boolean success = false;
		try {
			lock.lockInterruptibly();
		} catch (InterruptedException e) {

		}

		if (success) {
			try {
				System.out.println("Some operation in getValue");
			} finally {
				lock.unlock();
			}
		}

	}

	public void setValue() {

		lock.lock();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
