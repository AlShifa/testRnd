package com.syne.clon;

public class TestClo implements Cloneable {

	public static void main(String[] args) {

		TestClo testclo = new TestClo();
		try {
			TestClo t1 = (TestClo) testclo.clone();

		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
