package com.syne.weakref;

import java.util.HashMap;
import java.util.WeakHashMap;

//import java.lang.ref.Reference;

//import com.syne.weakref.Reference;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
//import com.syne.weakref.WeakReference;

public class TestWeakRef {

	public static void main(String[] args) {
		
		/*WeakRefCall wkCl = new WeakRefCall();
		
		//WeakReference wk = new WeakReference<WeakRefCall>(wkCl);
		//A a = new A();
		
		Reference myReference = new WeakReference( wkCl, new ReferenceQueue<WeakRefCall>() );
		wkCl = null;
		myReference.clear();
		WeakRefCall wkcl2 = (WeakRefCall)myReference.get();		
		System.out.println(wkcl2);
		System.out.println(wkcl2.i);
		Reference myReference1 = new WeakReference( "abc");
		System.out.println(myReference1);
		Reference myReference2 = new WeakReference( "abc");
		System.out.println(myReference2);
		WeakHashMap wkHmp = new WeakHashMap();
		
*/
	
		//SoftReference r = new SoftReference(new String("I'm here"));
	 	//SoftReference sr = new SoftReference("I'm here");
	 	
		AforGC a1 = new AforGC();
		a1.i=15;
		AforGC a2 = new AforGC();
		a2.i=20;
		//WeakReference r = new WeakReference(new String("I'm here"));
        //WeakReference sr = new WeakReference("I'm here");	 	
		
		ReferenceQueue<AforGC> queue = new ReferenceQueue<AforGC>();  
		ReferenceQueue<AforGC> queue2 = new ReferenceQueue<AforGC>();  
		WeakReference r = new WeakReference(a1);
        WeakReference sr = new WeakReference(new AforGC(),queue);	 	
		
        PhantomReference sr2 = new PhantomReference(new AforGC(),queue2);
	 	//PhantomReference r = new PhantomReference(new String("I'm here"), new ReferenceQueue());
	 	//PhantomReference sr = new PhantomReference("I'm here",new ReferenceQueue());
	 	
        System.out.println("before gc: r=" + r.get() +"queue"+queue.poll()+ ", static=" + sr.get());
        System.out.println(",phantam ref"+sr2.get());
        System.gc();
        
        try {
			Thread.sleep(10);
			System.out.println(sr+"[queue1]");
			System.out.println(sr2+"[queue2]");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // only r.get() becomes null
        System.out.println("after gc: r=" + r.get() + ", static=" + sr.get());
		  System.out.println(" phantom=" + sr2.get());
		  
		  HashMap<String,Integer> hmap2 = new HashMap<String,Integer>();
		  
		  Integer hmap = hmap2.put("dddd",2);
		  System.out.println("8888888888"+hmap);

		
		
	}

}
