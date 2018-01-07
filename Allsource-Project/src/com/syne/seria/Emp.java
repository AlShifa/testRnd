package com.syne.seria;

import java.io.Serializable;

public class Emp implements Comparable<Emp> , Serializable{
	private int empId;
	private String empName;
	private double salary;
	
	
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(int empId, String empName, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return empId+" "+empName+" "+salary;
	}
	@Override
	public int compareTo(Emp e) {
		//return this.empId - e.empId;
		return this.empName.compareTo(e.empName);
	}
}
