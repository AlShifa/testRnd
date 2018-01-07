package com.syne.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class RetrieveArrayList {
	
	public static void main(String[] arg) {
		
		Emp emp1 = new Emp(11,"dbc");
		Emp emp2 = new Emp(2,"aef");
		Emp emp3 = new Emp(5,"gef");
		HashSet<Emp> hsEmp= new HashSet<Emp>(); 
		hsEmp.add(emp1);
		hsEmp.add(emp2);
		hsEmp.add(emp3);
		ArrayList<HashSet<Emp>> ary = new ArrayList<HashSet<Emp>>();	
		ary.add(hsEmp);
		//ary.add(emp1);
		//ary.add(emp2);
		//ary.add(emp3);		
		
}

}
