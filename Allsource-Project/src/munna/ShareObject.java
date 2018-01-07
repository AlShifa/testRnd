package munna;



import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;



public class ShareObject {
	
	int count =0;
	
	int get()
	{
		return count;
	}
	void set()
	{
		count++;
	}
	
public static void main(String[] args) {
	System.out.println("static method");
	//Unsafe uns = Unsafe.getUnsafe();
	//ConcurrentLinkedQueue<E>
	//LinkedBlockingQueue<E>
	//Condition
	//System.out.println(uns);
	//SynchronousQueue<E>
	//ReentrantLock
	
}
}
