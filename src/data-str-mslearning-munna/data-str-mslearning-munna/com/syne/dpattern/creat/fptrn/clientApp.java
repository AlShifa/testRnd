package com.syne.dpattern.creat.fptrn;

public class clientApp {

	public static void main(String[] args) {
		// at run time
		String name = "Ashok";// arg[0]
		String gender = "F"; // arg[1]
		Person person = clientApp.getPerson(name, gender);
		System.out.println(person.getClass());
	}

	public static Person getPerson(String name, String gender) {

		if (gender.equals("M"))
			return new Male(name, gender);
		if (gender.equals("F"))
			return new Female(name, gender);
		else 
			return null;

	}

}
