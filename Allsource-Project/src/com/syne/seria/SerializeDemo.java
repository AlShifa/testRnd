package com.syne.seria;

import java.io.*;
public class SerializeDemo {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.setName("Reyan Ali");
		e.setAddress("Phokka Kuan, Ambehta Peer");
		e.setSSN(2222222);
		e.setNumber(101);
		try {
			FileOutputStream fileOut = new FileOutputStream("D:\\employee.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);			
			e.setNumber(102);
			out.reset();
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}
