package com.syne.thr;

public class StackImp {
	int top = 0;
	Object[] object = null;// new Object[];

	StackImp(int size) {
		object = new Object[size];		
	}

	void push(Object value) {
		if (top == object.length - 1)
			System.out.println("Stack is Full");
		else {
			top++;
			object[top] = value;
		}
	}

	Object pop() {
		if (top < 0) {			
			return 0;
		} else {
			Object value = object[top];
			top--;
			return value;
		}

	}

}
