package com.core.process;

public class CoreProcessor {
	
	public static void main(String[] args) {
		
		Runtime runtime  = Runtime.getRuntime();
		int core = runtime.availableProcessors();
		System.out.println("Hello worl"+core);
	}

}
