package demo;

import java.io.Serializable;

public class CompositeEmp implements Serializable
{
	private String projNo;
	private int empno;
	private String ename;
	private double salary;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "CompositeEmp [projNo=" + projNo + ", empno=" + empno
				+ ", ename=" + ename + ", salary=" + salary + "]";
	}
	public String getProjNo() {
		return projNo;
	}
	public void setProjNo(String projNo) {
		this.projNo = projNo;
	}
	
	
}
