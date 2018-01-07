package com.syne.clon;

import java.util.LinkedList;

public class HelloClone implements Cloneable {

	/**
	 * @param args
	 */
	String str = "abc";
	StringBuffer stbuf = new StringBuffer("abc");
	private LinkedList names = new LinkedList();
	private Object obj = new Object();

	/*//@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		HelloClone s = (HelloClone) super.clone();
		s.names = (LinkedList) names.clone();
		s.stbuf = new StringBuffer(this.stbuf);
		
		return s;
		//return super.clone(); //shalow copy and above is deep copy(deeply data copied into memory even references is alos copied)
	}*/

	public static void main(String[] args) {


		HelloClone helloClone = new HelloClone();
		System.out.println(helloClone);
		helloClone.names.add("hello");
		try {
			HelloClone getHelloClone = (HelloClone)helloClone.clone();
			System.out.println(getHelloClone);
			getHelloClone.names.add("hi");			
			getHelloClone.stbuf.append("def");
			System.out.println(getHelloClone.stbuf);
			System.out.println(getHelloClone.names);
			System.out.println(helloClone.stbuf);
			System.out.println(helloClone.names);

		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
