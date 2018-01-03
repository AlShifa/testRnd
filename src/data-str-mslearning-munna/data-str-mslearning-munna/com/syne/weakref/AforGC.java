package com.syne.weakref;

import java.util.WeakHashMap;

public class AforGC {
	
	int i =10;
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();		
		WeakHashMap<String,String> whmap = new WeakHashMap<String, String>();		
		String str = "abc";		
		//StringBuffer sb = new S		
		//str.getChars(srcBegin, srcEnd, dst, dstBegin)
	}
	public static void main(String[] args)throws Throwable {
		Class cls = Class.forName("com.syne.weakref.WeakRefCall");
		Object obj = cls.newInstance();
		System.out.println("obj"+obj);
		
		
		
	}

}
