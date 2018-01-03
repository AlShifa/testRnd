package com.syne.dpattern.creat.absfpt;

public class ConcreteFactory1 extends AbstractFactory {

	public  AbstractProductA CreateProductA()
	 
    {
 
      return new ProductA1();
 
    }
 
    public  AbstractProductB CreateProductB()
 
    {
 
      return new ProductB1();
 
    }

	
}
