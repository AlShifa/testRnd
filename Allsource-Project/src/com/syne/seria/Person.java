package com.syne.seria;

public class Person
implements java.io.Serializable
{
public Person(String fn, String ln, int a)
{
    this.firstName = fn; this.lastName = ln; this.age = a;
}

public String getFirstName() { return firstName; }
public String getLastName() { return lastName; }
public int getAge() { return age; }
public Person getSpouse() { return spouse; }

public void setFirstName(String value) { firstName = value; }
public void setLastName(String value) { lastName = value; }
public void setAge(int value) { age = value; }
public void setSpouse(Person value) { spouse = value; }

//special private method but call by JVM.
private void writeObject(java.io.ObjectOutputStream stream)
    throws java.io.IOException
{
	System.out.println("++++++++++++write+++++++++++");
    //"Encrypt"/obscure the sensitive data
    age = age >> 2;
    stream.defaultWriteObject();
}

//special private method but call by JVM.
private void readObject(java.io.ObjectInputStream stream)
    throws java.io.IOException, ClassNotFoundException
{
	System.out.println("+++++++readObject++++++++++++++++++");
    stream.defaultReadObject();

    // "Decrypt"/de-obscure the sensitive data
    age = age << 2;
}

public String toString()
{
    return "[Person: firstName=" + firstName + 
        " lastName=" + lastName +
        " age=" + age +
        " spouse=" + (spouse!=null ? spouse.getFirstName() : "[null]") +
        "]";
}      

private String firstName;
private String lastName;
private int age;
private Person spouse;
}
