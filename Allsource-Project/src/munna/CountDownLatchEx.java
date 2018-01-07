package munna;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx {
	
	static CountDownLatch count = new CountDownLatch(3);
	Runnable[] runn = new Runnable[3];
	
	public static void main(String[] args) {
		
		//for(int i =0;i<3;i++)			
		//{
			//new Thread(new Mythread(count, ""+i)).start();
			//new Mythread(count, ""+i);
		//}
		
		new Mythread(count, ""+1);
		new Mythread(count, ""+2);
		new Mythread(count, ""+3);

		try {
			count.await();
			System.out.println("resumed process");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static class Mythread implements Runnable
	{
		CountDownLatch countDownLatch;	
		Thread t ;
		
		public Mythread(CountDownLatch countDownLatch,String name) {
			//super();			
			this.countDownLatch = countDownLatch;
			t= new Thread(this);
			t.start();
			t.setName(name);
		}

		public void run()
		{
			try{
				Thread.sleep(2000);
			System.out.println(countDownLatch+"Runnable "+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				countDownLatch.countDown();
			}
		}
		
	}
	
	
	

}
