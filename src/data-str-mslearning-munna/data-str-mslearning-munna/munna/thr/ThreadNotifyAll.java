package munna.thr;

public class ThreadNotifyAll {
	static A a = new A();
	public static void main(String[] args) throws InterruptedException {
		final Thread t1=new Thread();
		MyRunnable my1 = new MyRunnable(""+1,t1);
		Thread.sleep(20);
		
		final Thread t2=new Thread();
		MyRunnable my2 = new MyRunnable(""+2,t2);
		Thread.sleep(20);
		
		/*final Thread t3=new Thread();
		MyRunnable my3 = new MyRunnable(""+3,t3);
		Thread.sleep(20);
		
		final Thread t4=new Thread();
		MyRunnable my4 = new MyRunnable(""+4,t4);
		Thread.sleep(20);
		
		final Thread t5=new Thread();
		MyRunnable my5 = new MyRunnable(""+5,t5);
		Thread.sleep(20);
		
		final Thread t6=new Thread();
		MyRunnable my6 = new MyRunnable(""+6,t6);
		Thread.sleep(20);*/
		
		Thread t = new Thread(){ public void run(){
			
			while(true){				
				
			System.out.println("[ status ] \n");
			System.out.print(" "+t1.getState());
			System.out.print(" "+t2.getState());
			/*System.out.print(" "+t3.getState());
			System.out.print(" "+t4.getState());
			System.out.print(" "+t5.getState());
			System.out.print(" "+t6.getState());*/
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
			
			
		} };
		t.start();
		
		
	}

	public static class MyRunnable implements Runnable {
		
		public MyRunnable(String name,Thread t)
		{
			t = new Thread(this);
			t.start();
			t.setName(name);
			
		}
		public void run() {
			while(true)
			{
				try {
					a.print();
					Thread.sleep(1000);					
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
			
			}
		}
	}
}
