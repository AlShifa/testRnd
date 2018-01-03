package com.syne.weakref.cache;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

//import org.apache.camel.language.Simple;

public class SimpleMap {
	HashMap hmp = new HashMap<String, String>();
	
	public static void main(String[] args) {		
		
		SimpleMap smp = new SimpleMap();
		int i=0 ;
		while(true)
		{
			//String str
			smp.hmp.put(i++,new WeakReference<String>(new String("two"+i)));
			smp.hmp.put(i++,new WeakReference<String>(new String("three"+i)));
			System.out.println("-----------------");
			
		}
		
	}

}
