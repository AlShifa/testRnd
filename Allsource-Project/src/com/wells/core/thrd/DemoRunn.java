package com.wells.core.thrd;

public class DemoRunn {

	/**
	 * @param args
	 */
	 Thread t1=null;
	Thread t2=null;
	Thread t3=null;
	public static void main(String[] args) {		
		
	Runnable[] run = new Runnable[3];
	DemoRunn de = new DemoRunn();
	
	run[0]= new RunThrd();
	run[1]= new RunThrd();
	run[2]= new RunThrd();
		
	//for(int i=0; i<3 ; i++)
	//{		
		 de.t1 = new Thread(run[0],"Manazir"+(0));
		 de.t1.start();
		 de.t2 = new Thread(run[1],"Manazir"+(1));
		 de.t2.start();
		 de.t3 = new Thread(run[2],"Manazir"+(2));
		 de.t3.start();
	//}

	}

}
