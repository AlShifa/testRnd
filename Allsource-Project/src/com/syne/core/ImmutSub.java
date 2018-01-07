package com.syne.core;

public class ImmutSub extends ImmutTest {
	private int id;
	private String name;
	public ImmutSub(Integer id, String name) {
		super(id, name);	
	}	
	public static void main(String[] args) {
		ImmutSub immuSub = new ImmutSub(101,"mohib");	
		
	}
	public String get()
	{
		return name;
		
		
	}
	
	

}
