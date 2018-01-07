package com.syne.seria;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersonApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Person per = new Person("Atul","Kumar",25);
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		// deep copy
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			oos = new ObjectOutputStream(bos);			
			oos.writeObject(per);
			oos.flush();
			ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bin);			
			Person perObjet2 = (Person) ois.readObject();
			System.out.println(perObjet2);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//java.io.NotSerializableException
		}
		

	}

}
