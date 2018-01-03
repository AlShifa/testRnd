package com.syne.Z.go.core.Refe;

import java.lang.ref.WeakReference;

public class WeakRef {
	
	
	public static void main(String[] args) {
		A a = new A();
		//WeakReference<A> wekRef = new WeakReference<A>(a);
		a = null;		
		System.gc();
	}

}
class A
{
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("AAAAAAAAAAAAAAAAAAA");
		super.finalize();
	}
	
}
