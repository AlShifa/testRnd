package com.wells.collec;

public class Employee implements Comparable<Employee> {
	private Integer id ;
	String name;
	public Employee(Integer id, String name) {
		//super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		int x =this.id.compareTo(o.id);
		//System.out.println(x);
		return x;
	}
	

}
