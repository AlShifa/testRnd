package LockImpl;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResourc {
	int x = 0;
	Lock lock = new ReentrantLock();
	Condition con = lock.newCondition();
	//Condition con2 = lock.newCondition();
	public void getValue() throws InterruptedException
	{
		lock.lock();
		x--;
		System.out.println("[G "+x +" ]");
		//Thread.sleep(100);
		con.signalAll();
		con.await();
		lock.unlock();
	}
	public void setValue() throws InterruptedException
	{
		lock.lock();
		x++;
		System.out.println("[s "+x+" ]");
		//Thread.sleep(100);
		con.await();
		con.signal();
		lock.unlock();
		
	}

}
