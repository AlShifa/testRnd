package com.coreJ;

public class ExecutionOrder {

	{
		System.out.println("Anonymous Block");
	}

	static {
		System.out.println("Static Block");
	}

	/*public ExecutionOrder() {
		System.out.println("Constructor");
	}*/

	public void instanceMethod() {
		System.out.println("Instance Method");
	}

	public static void main(String[] args) {
		ExecutionOrder executionOrder = new ExecutionOrder();
		//executionOrder.instanceMethod();
	}
}
