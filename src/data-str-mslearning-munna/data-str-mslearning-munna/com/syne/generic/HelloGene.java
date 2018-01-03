package com.syne.generic;

public class HelloGene<G> {
	
	private G g ;
	private void addValue(G g)
	{
		this.g = g;		
	}
	public G getValue()
	{
		return g;		
	}
	
	
	public static void main(String arg[]) {		
		
		HelloGene<Integer> hello1 = new HelloGene<Integer>();
		HelloGene<String> hello2 = new HelloGene<String>();
		hello1.addValue(new Integer(2));	
		hello2.addValue(new String("generic"));
		System.out.println(hello1.getValue());
		System.out.println(hello2.getValue());
		
		
	}

}
