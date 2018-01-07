package com.syne.seria;

import java.io.*;

public class Car implements Externalizable {

    String name;
    int year;

    /*
     * mandatory public no-arg constructor
     */
    public Car() { super(); }
    
    Car(String n, int y) {
	name = n;
	year = y;
    }

    /** 
     * Mandatory writeExernal method. 
     */
    public void writeExternal(ObjectOutput out) throws IOException  {
    	System.out.println("-----call writeExternal----------");
	out.writeObject(name);
	out.writeInt(year);
    }

    /** 
     * Mandatory readExternal method. 
     */
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    	
    	System.out.println("-----call readExternal----------");
	name = (String) in.readObject();
	year = in.readInt();
    }

    /** 
     * Prints out the fields. used for testing!
     */
    public String toString() {
        return("Name: " + name + "\n" + "Year: " + year);
    }
}
  
