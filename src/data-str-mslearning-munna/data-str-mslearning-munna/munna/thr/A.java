package munna.thr;

public class A {
	int i=1;
	synchronized void print() throws InterruptedException
	{
		System.out.println("status "+Thread.currentThread().getState()+" [ ] "+Thread.currentThread().getName()+"[]"+i);
		i++;		
		
		//System.out.println(i);		
		//String str= Thread.currentThread().getName();
		//if(str.equals("1"))
		//	System.out.println("even");
		//else
		//	System.out.println("odd");
		//notify();
		//wait();	
		
	}

}
