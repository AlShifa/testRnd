package com.wells.core;

public class EmployeeBean implements Comparable<EmployeeBean> {
	
	private int EmpId;
	private String EmpName;
	
	/*synchronized static void  k()
	{
		System.out.println("this is synechronized ");
	}
	 */
	@Override
	public int compareTo(EmployeeBean empBean){
		
		return this.EmpId - empBean.EmpId ;
	}

	public int getEmpId() {
		return EmpId;
	}

	public void setEmpId(int empId) {
		EmpId = empId;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

}
