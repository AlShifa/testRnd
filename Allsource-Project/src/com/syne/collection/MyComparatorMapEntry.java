package com.syne.collection;

import java.util.Comparator;
import java.util.Map;

public class MyComparatorMapEntry  implements Comparator<Map.Entry<Integer,Emp>> {
	private int type;
	//public int compare(Map.Entry<Integer, Emp> e1, Map.Entry<Integer, Emp> e2) {
	public int compare(Map.Entry<Integer, Emp> e1, Map.Entry<Integer, Emp> e2) {
		if(type == 1){			
			Emp first = (Emp) e1.getValue();
			Emp second = (Emp) e2.getValue();
			return first.getEmpId() - second.getEmpId();
		}if(type == 2){
			System.out.println("short on name  basis ");
			Emp first = (Emp) e1.getValue();
			Emp second = (Emp) e2.getValue();
			return first.getEmpName().compareTo(second.getEmpName());
		}
			else return 0;
	}

	public void setSortType(int type) {
		this.type = type;
		
	}

}
