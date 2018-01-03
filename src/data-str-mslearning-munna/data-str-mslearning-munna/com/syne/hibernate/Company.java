package com.syne.hibernate;

public class Company {
	
	@Override
	public String toString() {
		return "Company [Comp_Address=" + Comp_Address + ", Comp_Branch="
				+ Comp_Branch + ", Comp_Id=" + Comp_Id + ", Comp_Name="
				+ Comp_Name + "]";
	}
	private Integer Comp_Id ;
	private String  Comp_Name;
	private String Comp_Address;
	private String Comp_Branch;
	public Integer getComp_Id() {
		return Comp_Id;
	}
	public void setComp_Id(Integer compId) {
		Comp_Id = compId;
	}
	public String getComp_Name() {
		return Comp_Name;
	}
	public void setComp_Name(String compName) {
		Comp_Name = compName;
	}
	public String getComp_Address() {
		return Comp_Address;
	}
	public void setComp_Address(String compAddress) {
		Comp_Address = compAddress;
	}
	public String getComp_Branch() {
		return Comp_Branch;
	}
	public void setComp_Branch(String compBranch) {
		Comp_Branch = compBranch;
	}
	
	
	
	

}
