package com.syne.collection;

import java.util.Comparator;
import java.util.Map;

public class MyComparator implements Comparator<Emp>{

	private int type;

	@Override
	public int compare(Emp e1, Emp e2) {
		if(type == 1){
			return e1.getEmpId() - e2.getEmpId();
		}else if(type == 2){
			return e1.getEmpName().compareTo(e2.getEmpName());
		}
		return 0;
	}	

	public void setSortType(int type) {
		this.type = type;
		
	}

}
