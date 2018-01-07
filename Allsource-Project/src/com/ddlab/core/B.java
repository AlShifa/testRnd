package com.ddlab.core;

import java.io.IOException;
import java.lang.ref.WeakReference;

public class B extends A {
	
	
	void m() throws IOException
	{
		
	}
	
	/*public static void main(String[] args) {
		System.out.println("-----------");
	}*/	
/*public static void main(String[] args) {
	
	B a = new B();
	B b = new B();
	System.out.println("a"+a.hashCode());
	System.out.println("b"+b.hashCode());	
	a=null;	
	System.gc();
	a=b;
	System.out.println("a"+a.hashCode());	
	System.out.println("b"+b.hashCode());
	
	//A aa = new A();
	//aa.
	InterFace i = new InterFaceImplExt();
	System.out.println(i.equals(i));
	
	 WeakReference r = new WeakReference(new String("I'm here"));
     WeakReference sr = new WeakReference("I'm here");
     System.out.println("before gc: r=" + r.get() + ", static=" + sr.get());
     System.gc();   

     // only r.get() becomes null
     System.out.println("after gc: r=" + r.get() + ", static=" + sr.get());

	
}*/
	
}
