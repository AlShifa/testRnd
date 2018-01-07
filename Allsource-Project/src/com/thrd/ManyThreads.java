package com.thrd;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class ManyThreads {

	/**
	 * @param args
	 * @throws BrokenBarrierException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		CountShrdObj cnt =new CountShrdObj(0);
		
		//Here our implemented Runnable object, like thead, passes in CyclicBarrier object.
		/*CyclicBarrierThrd barrierThread = new CyclicBarrierThrd("barrier",cnt);
		CyclicBarrier cyBarrier = new CyclicBarrier(3,barrierThread);
				
		Runnable r2= new ThreadOne("Two",cyBarrier,cnt);
		Runnable r3= new ThreadOne("Three",cyBarrier,cnt);
		Runnable r1= new ThreadOne("One",cyBarrier,cnt);
		*/
		
		//Here countdownlatch object pass in our thead counstructore, reverse as cyclic barrier
		CountDownLatch countDownLtch = new CountDownLatch(2);
		CountDownThrd cntThread = new CountDownThrd(countDownLtch,"LathThread",cnt);		
		
		Runnable rCL2= new ThreadOneLatch("TwoCL",countDownLtch,cnt);
		Runnable rCL3= new ThreadOneLatch("ThreeCL",countDownLtch,cnt);
		Runnable rCL1= new ThreadOneLatch("OneCL",countDownLtch,cnt);
		
		
		

	}

}
