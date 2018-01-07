package munna;

//import com.syne.collection.HashMap;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

public class HashMapFail {
	
	public static void main(String[] args) {
		final HashMap<String, String> hmap = new HashMap<String, String>(2,10.10f);		
		//final ConcurrentHashMap<String, String> hmap = new ConcurrentHashMap<String, String>(2,10.10f);
		/*Thread t1 = new Thread()
		{
			public void run()
			{
				for(int i =0; i<100000;i++)
				{
					System.out.println("[ t1 ]"+i);
					hmap.put("i"+i, "i"+i);					
				}
				System.out.println("Thread 1 ");
			}
		};
		t1.start();
		Thread t2 = new Thread()
		{
			public void run()
			{
				for(int i =0; i<100000;i++)
				{
					System.out.println("[ t2 ]"+i);
					hmap.put("i"+i, "i"+i);					
				}
				System.out.println("*********Thread 2*****************");
			}
		};
		t2.start();*/
		
		/*Thread t3 = new Thread()
		{
			public void run()
			{
				for(int i =0; i<100000;i++)
				{
					System.out.println("[ t2 ]"+i);
					hmap.put("i"+i, "i"+i);					
				}
				System.out.println("*********Thread 3*****************");
			}
		};
		t3.start();
		
		
		Thread t4 = new Thread()
		{
			public void run()
			{
				for(int i =0; i<100000;i++)
				{
					System.out.println("[ t2 ]"+i);
					hmap.put("i"+i, "i"+i);					
				}
				System.out.println("*********Thread 4*****************");
			}
		};
		t4.start();		
		
		Thread t5 = new Thread()
		{
			public void run()
			{
				for(int i =0; i<100000;i++)
				{
					System.out.println("[ t2 ]"+i);
					hmap.put("i"+i, "i"+i);					
				}
				System.out.println("*********Thread 5*****************");
			}
		};
		t5.start();	*/
		
		Semaphore sp = new Semaphore(3, true);		
		/*sp.acquire();
		sp.availablePermits();
		sp.release();
		sp.drainPermits();
		sp.tryAcquire();
		*/
		
		int x =5;
		System.out.println(17%10);
	}

}
