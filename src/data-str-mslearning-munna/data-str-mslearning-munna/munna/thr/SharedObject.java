package munna.thr;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedObject {
	ReentrantLock lock = new ReentrantLock(); 
	Condition cond = lock.newCondition();
	Integer value= new Integer(0);
	int getValue()
	{		
		return value;
	}	
	void setValue()
	{
	//	this.value = 0;
		//synchronized (this) {	
		lock.lock();
			try {
				value++;
				System.out.println("[ Current Thread ]"+Thread.currentThread().getName()+"[ Value ]"+value);
				cond.signal();
				try {
					cond.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} /*catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			finally{
				lock.unlock();
			}
		//}
		
	}

}
