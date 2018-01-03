package com.syne.hibernate;


public class Employee {
	
	public String emp_Name;
	public String emp_Address;
	public String emp_Comp;
	public Double emp_Salary;
	public Integer Comp_Id;
	public Company comp;
	public Company getComp() {
		return comp;
	}
	public Integer getComp_Id() {
		return Comp_Id;
	}
	public void setComp_Id(Integer compId) {
		Comp_Id = compId;
	}
	public void setComp(Company comp) {
		this.comp = comp;
	}
	public String getEmp_Name() {
		return emp_Name;
	}
	@Override
	public String toString() {
		return "Employee [emp_Address=" + emp_Address + ", emp_Comp="
				+ emp_Comp + ", emp_Id=" + emp_Id + ", emp_Name=" + emp_Name
				+ ", emp_Salary=" + emp_Salary + "]";
	}
	public void setEmp_Name(String empName) {
		emp_Name = empName;
	}
	public String getEmp_Address() {		
		return emp_Address;
	}
	public void setEmp_Address(String empAddress) {
		emp_Address = empAddress;
	}
	public String getEmp_Comp() {
		return emp_Comp;
	}
	public void setEmp_Comp(String empComp) {
		emp_Comp = empComp;
	}
	public Double getEmp_Salary() {
		return emp_Salary;
	}
	public void setEmp_Salary(Double empSalary) {
		emp_Salary = empSalary;
	}
	public Integer getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(Integer empId) {
		emp_Id = empId;
	}
	Integer emp_Id;
	

}
