package LockImpl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableMain {

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		//Executors ext = new
		MYCallable myCall = new MYCallable();
		/*FutureTask<String> fut = new FutureTask<String>(myCall);
		fut.run();
		System.out.println(fut.get());
		*/
		
		// Second Way using Executors
		
		//Executors
		ExecutorService exs = Executors.newFixedThreadPool(3);
		Future<String> futTaks = exs.submit(myCall);
		//Future<String> futTaks2 = exs.submit(myCall);
		System.out.println("kk"+futTaks.get());
		//System.out.println(futTaks2.get());
		exs.shutdown();

	}

	public static class MYCallable implements Callable<String> {
		int count;
		
		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			return "Hello \t " + count;
		}

	}
}
