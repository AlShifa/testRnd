package com.syne.seria.xmlSeriali;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class XmlDeserialization {

	public static void main(String[] args) {

		FileInputStream os;
		try {
			os = new FileInputStream("D:/cust.xml");
			XMLDecoder decoder = new XMLDecoder(os);
			Person p = (Person) decoder.readObject();
			decoder.close();
			System.out.println(p.getFirstName());
			System.out.println(p.getLastName());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
