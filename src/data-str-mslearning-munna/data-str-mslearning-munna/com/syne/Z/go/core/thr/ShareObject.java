package com.syne.Z.go.core.thr;

import java.util.ArrayList;

public class ShareObject {

	int size;
	ArrayList<Integer> ary;
	
	public ShareObject(int size) {
		this.size = size;
		ary = new ArrayList<Integer>(size);

	}
	Integer getArryLst() throws InterruptedException {		
		synchronized (ary) {
			if (ary.size() > 0) {
				for (int index = 0; index <= size; index++) {
					Integer retNum = ary.get(index);
					System.out.println("[ Consumed ]" + retNum);
					ary.remove(index);
					ary.notify();
					Thread.sleep(1000);
					return 0;
				}

			} else {
				ary.wait();
			}

		}
		return null;
	}

	void setArryLst(int index) throws InterruptedException {

		synchronized (ary) {

			if (ary.size() <= size) {
				System.out.println("[ Produced ]" + index);
				ary.add(index);
				ary.notify();
				Thread.sleep(1000);

			} else {
				ary.wait();
			}
		}
	}

}
