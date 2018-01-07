package com.syne.thr.ms;

import java.util.ArrayList;

public class SharableCls {

	ArrayList<Long> arylst = new ArrayList<Long>();

	void put(Long value) {

		synchronized (arylst) {
			if (arylst.size() == 10) {
				try {
					arylst.wait(); // wait for empty;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("[producer ]" + value);
				arylst.add(value);								
				try {
					arylst.notify();
					arylst.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	Long get(int index) {		
		synchronized (arylst) {			
			if (arylst.isEmpty()) {
				try {
					arylst.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 0l;
			} else {
				
				arylst.notify();
				try {
					arylst.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				long var = arylst.get(index);
				System.out.println("index"+index+"arylst.get(index)"+var);
				return var ;
			}
		}// synechro

	}

}
