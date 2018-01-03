package com.syne.core;

public class A {
	
	protected int k =10;
	public int g =20;
	//private int test  =10;
	
	B b = null;
	int i =10;
	static float f =10;

	void  test()
	{
		
	}
protected void finalize() throws Throwable { 
	
	B b1 = null;
	//ConcurrentReaderHashMap chm = new ConcurrentReaderHashMap(); 
		
		System.out.println("in finalize A "+Thread.currentThread().getName());
	}


}
