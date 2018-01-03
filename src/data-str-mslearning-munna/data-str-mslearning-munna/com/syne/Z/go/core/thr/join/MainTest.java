package com.syne.Z.go.core.thr.join;

import java.util.ArrayList;

public class MainTest {
	static ThreadJoin1 tj1 =null;
	static	ThreadJoin2 tj2 = null;
	static Thread th1=null;
	static Thread th2=null;
	public static void main(String[] args) {
		
		/*ArrayList<String> aryList = new ArrayList<String>();
		aryList.add("one");
		aryList.add("two");
		System.out.println(aryList.size());
		aryList.add(3, "three");
		System.out.println(aryList);		
		 System.out.println("main method ");*/		
		tj1 = new ThreadJoin1();	
		tj2 = new ThreadJoin2();		
		tj1.setThreadJoin1(tj2);
		tj2.setThreadJoin2(tj1);		
		tj2.setPriority(6);
		tj1.setPriority(5);		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		tj1.start();
		
		tj2.start();	
			
		
		
	}

}
