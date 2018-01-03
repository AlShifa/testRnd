package com.syne.thr;

import java.util.ArrayList;
import java.util.List;

public class B extends A {
	

	synchronized void n() {
		System.out.println("B's method ");
	//	m();
		List<String> aryList = new ArrayList<String>();

	}
	public static void main(String[] args) {

		B b = new B();
		b.n();
		System.out.println(b.it);
		//B.k=10;

	}

}
