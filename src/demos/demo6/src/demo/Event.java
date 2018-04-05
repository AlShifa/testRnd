package demo;

import java.util.HashSet;
import java.util.Set;

public class Event {
	private int eid;
	private String desc;
	
	private Set<Person> people = new HashSet<Person>();
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Event [eid=" + eid + ", desc=" + desc + "]";
	}
	public Set<Person> getPeople() {
		return people;
	}
	public void setPeople(Set<Person> people) {
		this.people = people;
	}
	
}
