package com.syne.collection;

public class Emp1 {
	
	private int name;
	private int salary;
	
	
	

	
	 public Emp1(int name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}





	@Override
	public int hashCode() {
		return 5;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp1 other = (Emp1) obj;
		if (name != other.name)
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}





	public static void main(String[] args) {
		
		 Emp1 e = new Emp1(1, 25);
		 Emp1 e1 = new Emp1(1, 25);
		 
		 System.out.println(e.hashCode() +" " +e1.hashCode());
		 
		 
		 
		 
	}
}
