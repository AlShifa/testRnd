package com.syne.core;

public class ImmutTest {
	
	private final Integer id ;	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	private final String name ;
	
	//private ImmutTest()
	public ImmutTest(Integer id ,String name)
	{		
		this.id =id;
		this.name = name;
	}
	
	

}
