package com.wells.core;

import java.util.Comparator;

public class EmployeeBeanComparatorImpl implements Comparator<EmployeeBean> {

	int orderSequence = 0;
	@Override
	public int compare(EmployeeBean arg1, EmployeeBean arg2) {
		
		String empName1 = arg1.getEmpName();
		String empName2 = arg2.getEmpName();
	
		if(orderSequence==1)		
		return empName1.compareTo(empName2);
		else if(orderSequence==0)
			return arg1.getEmpId() -  arg2.getEmpId();
		
		return orderSequence;
			
	}

}
