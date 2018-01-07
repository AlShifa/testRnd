package com.syne.seria;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class HelloSeria {

	public static void main(String[] args) {
		String str = new String();
		//Object
		Emp empObjet = new Emp();
		empObjet.setEmpId(1);
		empObjet.setEmpName("abhinash");
		empObjet.setSalary(11.0);

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		// deep copy
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			oos = new ObjectOutputStream(bos);			
			oos.writeObject(empObjet);
			oos.flush();
			ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bin);			
			Emp empObjet2 = (Emp) ois.readObject();
			System.out.println(empObjet2);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//java.io.NotSerializableException
		}
		

	}

}
