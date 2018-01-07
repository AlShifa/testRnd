package com.coreJ;

public class Duck {
	Flyable fly;
	public void setFly(Flyable fly) {
		this.fly = fly;
	}
	void perform()
	{
		fly.fly();
		
	}
	void m()
	{}
	void n(){}
	
	public static void main(String[] args) {
		Duck duck = new Duck();
		//duck.perform();
	}

}
