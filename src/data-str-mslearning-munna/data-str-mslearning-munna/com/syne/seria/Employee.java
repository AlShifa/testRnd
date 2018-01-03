package com.syne.seria;

public class Employee extends A implements java.io.Serializable
{
  
	private String name;   
   private String address;
   private transient int  SSN;
   private int number;
   public String getName() {
	return name;
}
   int i= 10;
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getSSN() {
	return SSN;
}
public void setSSN(int sSN) {
	SSN = sSN;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public int getPin() {
	return pin;
}
public void setPin(int pin) {
	this.pin = pin;
}
private int pin=10;

   private void mailCheck()
   {
      System.out.println("Mailing a check to " + name
                           + " " + address);
   }
}

