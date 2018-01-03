package com.syne.dpattern.creat.absfpt;

public class Client {

	private AbstractProductA abstractProductA;
	private AbstractProductB abstractProductB;

	public Client(AbstractFactory factory)
	{
		abstractProductB = factory.CreateProductB();
		abstractProductA = factory.CreateProductA();
	}
	public void Run()
	{
		abstractProductB.Interact(abstractProductA);
	}
}
