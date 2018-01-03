package com.syne.sington;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool.SynchronizedGrammarPool;

class Singleton {
	private static Singleton instance;
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) { // 1
				Singleton inst = instance; // 2
				if (inst == null) {
					synchronized (Singleton.class) { // 3
						instance = new Singleton();
					}
				}
			}
		}
		return instance;
	}
	
	
	private Singleton()
	{
		
	}
	public static Singleton getSingleton()
	{
		if(instance!=null)
		{
			return instance;
		}else
		{
			synchronized(Singleton.class)
			{
			instance= new Singleton();
			}
			return instance;
			
		}
		
	}
}
