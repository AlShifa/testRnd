package munna;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.sf.saxon.instruct.CopyOf;

public class ExecutorFrameWork {	
static Runnable[] runn = new Runnable[3];
	
	public static void main(String[] args) {	
		
		
		 ExecutorService executor = Executors.newFixedThreadPool(10);	
		 ShareObject shareObj = new ShareObject();
		 
		//for(int i =0;i<3;i++)
		//{
			executor.execute(new MyRunnable("[ ThreadName] "+0,shareObj));
			executor.execute(new MyRunnable("[ ThreadName] "+1,shareObj));
		//}		
			System.out.println("Complete Run method");
		executor.shutdown();		
		//CountDownLatch
		//CyclicBarrier
		//Semaphore
		//ThreadPoolExecutor
			
			
	}		
	static class MyRunnable implements Runnable
	{			
		String threadName;
		ShareObject shareObj;
		MyRunnable(String threadName,ShareObject shareObj)
		{	this.threadName = threadName;	
			this.shareObj = shareObj;			
		}		
		public void run()
		{
			//while(true){				
			try {
				System.out.println("[ run thread ]"+threadName);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//}
		}
	}

}
