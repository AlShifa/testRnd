package com.syne.dpattern.creat.absfpt;

public class ConcreteFactory2 extends AbstractFactory {

	public  AbstractProductA CreateProductA()
	 
    {
 
      return new ProductA2();
 
    }
 
    public  AbstractProductB CreateProductB()
 
    {
 
      return new ProductB2();
 
    }

	
}
