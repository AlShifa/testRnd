package com.syne.thr.ms;

public class ProConStackData {

	volatile Object[] data = null;
	volatile int pointer = -1; //end point

	public ProConStackData(int size) {
		data = new Object[size];
	}

	synchronized Object getData() {
		if (pointer == -1) {
			System.out.println(pointer + " List is empty wait for producer "
					+ Thread.currentThread().getName());
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0l;
		} else {

			long getDataValue = (Long)data[pointer];
			data[pointer] = null;
			pointer = pointer - 1;
			System.out.println("pointer: :" + pointer + "[=======pros======]"
					+ getDataValue + ": " + Thread.currentThread().getName());
			notify();
			/*try {
				
				//wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			return getDataValue;
		}
	}

	synchronized void setData(Object element) {
		if (pointer >= data.length) {
			System.out.println(" List is full , wait for the consumming"
					+ Thread.currentThread().getName());
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			pointer = pointer + 1;
			data[pointer] = element;
			System.out.println("pointer: :" + pointer + " [=======cons======]"
					+ element + ": " + Thread.currentThread().getName());
			notifyAll();
			/*try {				
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

		}
	}

}
