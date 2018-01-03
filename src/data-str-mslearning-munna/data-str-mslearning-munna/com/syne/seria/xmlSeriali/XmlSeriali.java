package com.syne.seria.xmlSeriali;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XmlSeriali {

	public static void main(String[] args) {

		FileOutputStream os;
		try {
			os = new FileOutputStream("D:\\cust.xml");
			XMLEncoder encoder = new XMLEncoder(os);
			Person p = new Person(); //"Manazir","Khan"
			p.setFirstName("Raja");
			p.setLastName("Khan");
			encoder.writeObject(p);
			encoder.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
