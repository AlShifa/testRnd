package munna.thr;

public class ThreadNotifyAl {
	final static A a = new A();

	public static void main(String[] args) {
		final Thread t2 = new Thread() {

			public void run() {

				try {
					while(true)
					{
					a.print();
					//Thread.sleep(10);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		System.out.println("[ current status of t2 ]" + t2.getState());
		t2.setName("t2 get");
		t2.start();

		final Thread t3 = new Thread() {

			public void run() {

				try {
					while(true)
					{
					a.print();
					//Thread.sleep(10);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		System.out.println("[ current status of t3 ]" + t3.getState());
		t3.setName("t3 get");
		t3.start();

		final Thread t4 = new Thread() {
			public void run() {
				try {
					while(true)
					{
					a.print();
					//Thread.sleep(10);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		System.out.println("[ current status of t4 ]" + t4.getState());
		t4.setName("t4 get");
		t4.start();

		final Thread t5 = new Thread() {
			public void run() {
				try {
					while(true)
					{
					a.print();
					//Thread.sleep(10);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		System.out.println("[ current status of t5 ]" + t5.getState());
		t5.setName("t5 get");
		t5.start();
		
		final Thread t6 = new Thread() {

			public void run() {
				for (int i = 0; i < 10000; i++) {

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("[ t2 set status ]" + t2.getState()
							+ "[ t3 get status]" + t3.getState() + "[ t4 get status]" + t4.getState()+ "[ t5 get status]" + t5.getState());
				}
			}

		};
		t6.setPriority(7);
		t6.start();
	}

}
