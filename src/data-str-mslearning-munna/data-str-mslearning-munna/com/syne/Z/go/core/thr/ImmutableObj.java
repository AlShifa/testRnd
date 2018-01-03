package com.syne.Z.go.core.thr;

public final class ImmutableObj {
	
	private final String name;
	
	ImmutableObj(String name )
	{
		this.name = name;	
		
	}
	public  String getName()
	{
		return name;
		
	}
}

  class ImmutableObj2 {
	
	private final String name;
	
	private ImmutableObj2(String name )
	{
		this.name = name;	
		
	}
	public  String getName()
	{
		return name;
		
	}
	public static  ImmutableObj2 getInstanceofImmutableObj2() {
		// TODO Auto-generated method stub
		ImmutableObj2 immut = new ImmutableObj2("all");
		return immut;
	}
	
	

}
