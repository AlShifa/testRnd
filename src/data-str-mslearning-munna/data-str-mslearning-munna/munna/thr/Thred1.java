package munna.thr;

public class Thred1  {
	final static A a = new A();
	public static void main(String[] args) {
		MyRunnable my1 = new MyRunnable(1);
		MyRunnable my2 = new MyRunnable(2);
		
		
	}
	static class MyRunnable implements Runnable
	{
		MyRunnable(int i)
		{
			Thread t = new Thread(this);
			t.setName(""+i);
			t.start();
		}
		public void run()
		{
			try {
				while(true){
				a.print();
				Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
