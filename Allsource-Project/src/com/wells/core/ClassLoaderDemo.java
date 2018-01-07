package com.wells.core;

public class ClassLoaderDemo {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		Class cls = Class.forName("com.wells.core.EmployeeBean");
		System.out.println(cls.getClass());
	//	class c = cls.getClass();
		System.out.println(cls.getName());
		EmployeeBean emp = (EmployeeBean)cls.newInstance();
		emp.setEmpId(1);
		System.out.println(emp.getEmpId());
		Thread th = new Thread();
	}

}
