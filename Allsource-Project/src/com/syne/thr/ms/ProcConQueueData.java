package com.syne.thr.ms;

public class ProcConQueueData {

	volatile Object[] data = null;
	volatile int sp = -1; //start point
	volatile int ep = -1; //end point

	public ProcConQueueData(int size) {
		data = new Object[size];
	}

	synchronized Object getData() {
		if (sp == -1) {
			System.out.println("List is empty wait for producer "
					+ Thread.currentThread().getName());
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0l;
		}else if (sp == ep ) // only one data in queue after consuming set as empty.
		{
			long getDataValue = (Long)data[ep];
			data[ep] = null;
			//ep = ep - 1;			
			System.out.println("sp or ep equals" + sp + "[=======cons======]"
					+ getDataValue + ": " + Thread.currentThread().getName());
			try {
				sp = -1;
				ep=-1;
				notify();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			return getDataValue;
			
			
		}
		else {

			long getDataValue = (Long)data[sp];
			data[sp] = null;			
			System.out.println("more data " + sp + "[=======cons======]"
					+ getDataValue + ": " + Thread.currentThread().getName());
			try {
				sp = sp + 1;
				notify();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return getDataValue;
		}
	}

	synchronized void setData(Long element) {
		if (sp >= data.length) {
			System.out.println(" List is full , wait for the consumming"+ Thread.currentThread().getName());
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(sp == ep && (  sp==-1 && ep ==-1 )) // initializing queue
		{
			ep = ep + 1;
			sp = sp + 1;
			data[ep] = element;
			System.out.println("ep: :" + ep + " [=======prod===initializing=queue==]"
					+ element + ": " + Thread.currentThread().getName());
			try {
				notifyAll();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else  {
			ep = ep + 1;
			data[ep] = element;
			System.out.println("ep: :" + ep + " [=======prod======]"
					+ element + ": " + Thread.currentThread().getName());
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
