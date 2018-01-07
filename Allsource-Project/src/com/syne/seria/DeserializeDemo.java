package com.syne.seria;

import java.io.*;
public class DeserializeDemo
{
   public static void main(String [] args)
   {
      Employee e = null;
	 //  Object e = null;
      try
      {
         FileInputStream fileIn = new FileInputStream("D:\\employee.txt");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (Employee) in.readObject();
         in.close();
         fileIn.close();
     }catch(IOException i)
     {
         i.printStackTrace();
         return;
     }catch(ClassNotFoundException c)
     {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return;
     }
     System.out.println("Deserialized Employee...");
     System.out.println("Name: " + e.getName());
     System.out.println("Address: " + e.getAddress());
     System.out.println("SSN: " + e.getSSN());
     System.out.println("Number: " + e.getNumber());
     System.out.println("Pin: " + e.getPin());
     System.out.println("A: " +e.getSuper());
 }
}

