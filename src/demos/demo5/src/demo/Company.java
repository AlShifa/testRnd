package demo;

import java.util.HashSet;
import java.util.Set;

public class Company {
	private int cno;
	private String name;
	private String addr;
	
	private Set<Representative> reps = new HashSet<Representative>();
	
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Company [cno=" + cno + ", name=" + name + ", addr=" + addr
				+ "]";
	}
	public Set<Representative> getReps() {
		return reps;
	}
	public void setReps(Set<Representative> reps) {
		this.reps = reps;
	}
	
}
