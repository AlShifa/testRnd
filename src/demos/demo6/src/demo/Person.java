package demo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Person {
	private String pid;
	private String name;
	private Date bdate;
	
	private Set<Event> events = new HashSet<Event>();
	
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", name=" + name + ", bdate=" + bdate
				+ "]";
	}
	public Set<Event> getEvents() {
		return events;
	}
	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
	
}
