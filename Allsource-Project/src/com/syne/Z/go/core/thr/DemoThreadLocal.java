package com.syne.Z.go.core.thr;

import java.util.ArrayList;

public class DemoThreadLocal {

	final static ThreadLocal<String> thredLocal = new ThreadLocal<String>();
	final static ThreadLocal<String> thredLocal2 = new ThreadLocal<String>();
	final static ThreadLocal<String> thredLocal3 = new ThreadLocal<String>();
	final static A a = new A();
	
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(){
			
			public void run()
			{
				thredLocal.set("One");
				a.set(1);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(thredLocal.get()+"[]"+a.get());
				
			}
		};
		t1.start();
				
		
Thread t2 = new Thread(){
			
			public void run()
			{
				thredLocal.set("two");
				a.set(2);
				System.out.println("call thread 2");
				
			}
		};
		t2.start();

		
	}
	

}
 class A{
	int var = 10;
	void set(int var)
	{
		this.var =var;
		
	}
	int get()
	{
		return var;
		
	}
}
