public class ThreadLocalDemo {

	private static ThreadLocal<String> transaction = new ThreadLocal<String>();

	public static void main(String[] args) {

		Thread t1 = new Thread() {

			public void run() {
				transaction.set("tranaction 1");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(transaction.get());

			}

		};

		Thread t2 = new Thread() {

			public void run() {
				transaction.set("tranaction 2");

			}

		};

		t1.start();
		t2.start();
		System.out.println("Threads started");

	}
}
