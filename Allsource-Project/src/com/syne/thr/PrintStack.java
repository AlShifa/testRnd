package com.syne.thr;

public class PrintStack {

	Object[] element = new Object[2000];
	int counter;

	synchronized void push(Object element) {
		this.element[++counter] = element;
		System.out.println("PUSH:" + element+"[SIZE]:"+this.element.length);
	}

	synchronized Object pop()
	{
		 if(counter >=0 )
		 {
			 Object element1 = element[counter--];
			 counter--;
			 System.out.println("Pop:"+element1+"[SIZE]:"+element.length);
			 return element1;
		  }else
			  return null;
		
		
	}
}
