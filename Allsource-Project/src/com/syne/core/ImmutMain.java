package com.syne.core;



public class ImmutMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		ImmutTest imtest = new ImmutTest(101,"manazir");		
		System.out.println(imtest.getId());
		System.out.println(imtest.getName());
		
		
		//private final static Unsafe unsafe = Unsafe.getUnsafe();
		
		

	}

}
