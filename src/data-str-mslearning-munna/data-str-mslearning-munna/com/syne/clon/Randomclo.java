package com.syne.clon;

public class Randomclo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		TestClo testclo = new TestClo();	
		try {
			TestClo t1 = (TestClo)testclo.clone();
		}catch (CloneNotSupportedException e) {		
			e.printStackTrace();
		}

	}

}
