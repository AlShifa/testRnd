package com.wells.core.thrd;

import java.util.ArrayList;

public class SharedObjectt {

	 ArrayList<Integer> x = new ArrayList<Integer>();

	synchronized void setValue(int i) {
		try {
			if (x.size() == 9999)
				wait();
			else {
				x.add(i);
				System.out.println(Thread.currentThread()+"[ pp ]"+i);
				notify();
				wait();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	synchronized void getValue(int i)
	{
		
		try{
			if(x.size()==0)
			{
				wait();
			}else{
				int y =  x.get(i);
				System.out.println(Thread.currentThread()+"[ cc ]"+y);
				notify();
				wait();
			}
			
			
		}catch(Exception ex){}
	}

}
