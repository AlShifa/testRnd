package com.syne.generic;

public class Emp  implements Comparable<Emp> {
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	String name;
	@Override
	public int compareTo(Emp o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}

}
