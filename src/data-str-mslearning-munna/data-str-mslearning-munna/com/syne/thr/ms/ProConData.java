package com.syne.thr.ms;

public class ProConData {

	//makes data and pointer var as master value  ,instead of threads local copy or thread cache. 
	volatile Object[] data = null; 
	volatile int pointer = -1;

	public ProConData(int size) {
		data = new Object[size];
	}

	synchronized Object getData() {
		//if list is empty, wait for data produce by others threads
		if (pointer==-1) {			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0l;
		} else {			
			//data consume and notify to all threads ,ready to data produce and then immediately release the lock. 
			long getDataValue = (Long)data[pointer];			
			data[pointer] = null;	
			pointer = pointer-1;
			System.out.println("pointer: :"+pointer+"[=======cons======]" + getDataValue+ ": " +Thread.currentThread().getName());			
			try {
				notifyAll();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return getDataValue;
		}
	}

	synchronized void setData(Object element) {
		//if list is full , wait for the data consume by other threads
		if (pointer >= data.length) {			
			try {
				wait();				
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		} else {
			//data produce and notify to all threads for consume and immediately release the locks.
			pointer= pointer + 1;
			data[pointer] = element;			
			System.out.println("pointer: :"+pointer+" [=======prod======]"+element+ ": "+Thread.currentThread().getName());			
			try {
				notifyAll();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
}
