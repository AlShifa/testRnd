package com.syne.dpattern.creat.absfpt;

public class ProductB2 extends AbstractProductB {
	
	public  void Interact(AbstractProductA a)
	 
    {
 
     System.out.println(this.getClass().getName() + " interacts with " + a.getClass().getName());
 
    }


}
