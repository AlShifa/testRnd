package com.syne.thr;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThrExecutor {

	public static void main(String arg[]) { // Executor is an object that
											// executes Runnable tasks. It is
											// similar to calling
		// new Thread (aRunnableObject).start ();
		// The new java.util.concurrent.Callable interface is much like Runnable
		// but overcomes two drawbacks with Runnable. The run() method in
		// Runnable
		// cannot return a result (i.e. it returns void)
		// and cannot throw a checked exception.
		// If you try to throw an exception in a run() method, the javac
		// compiler insists
		// that you use a throws clause in the method signature.
		// However, the superclass run() method doesn't throw an exception,
		// so javac will not accept this.
		// lock
		// The Lock framework in java.util.concurrent.lock is an abstraction for
		// locking, allowing
		// for lock implementations that are implemented as Java classes
		// rather than as a language feature

		// If use one thread pool with one thread which executes
		// several runnables you can use Executors.newSingleThreadExecutor();
		// Executor executor1 = Executors.newSingleThreadExecutor();

		// final PrintStack pstack = new PrintStack();
		// Runnable r = new RunableCls(pstack);
		// Runnable r2 = new RunableCls2(pstack);
		// use service
		// ExecutorService executorService = Executors.newFixedThreadPool (30);
		// executorService.execute (r2);
		// executorService.execute (r);
		// executorService.shutdown();
		// while (!executorService.isTerminated()) ;

		// use executor
		// Executor executor = Executors.newFixedThreadPool(2);
		// executor.execute(r2);
		// executor.execute(r);

		ExecutorService executor = Executors.newFixedThreadPool(3);
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		Callable<Integer> worker = new MyCallable();
		Future<Integer> submit = executor.submit(worker); //it execute the call method 
		//list.add(su  bmit);		
		int sum = 0;
		//for (Future<Integer> future : list) {
			try {
				// sum += future.get();
				System.out.println(submit.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		//}
		System.out.println(sum);
		executor.shutdown();
		while (!executor.isTerminated());
		
		
		/*
		 * FutureTask task = new FutureTask (new MyCallable ());
		 *  ExecutorService es = Executors.newSingleThreadExecutor ();
		 *   es.submit (task); 
		 *   try {
		 * int result = (Integer)task.get(); 
		 * System.out.println("Result from task.get () = " + result); }
		 * catch (Exception e) {
		 * System.err.println (e); } es.shutdown ();
		 * }
		 */		
		Lock lock = new ReentrantLock();
		lock.lock();
		
		//critical code to access multiple threads
		//counter++;
		
		lock.unlock();//release the locks 
	}

}
