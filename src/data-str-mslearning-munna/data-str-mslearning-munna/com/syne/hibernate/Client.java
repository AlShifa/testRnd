package com.syne.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ddlab.core.Emp;

public class Client {

	public static void main(String[] args) throws SecurityException, IllegalStateException{						
		 SessionFactory sessionFactory = new Configuration().configure("com/syne/hibernate/hibernate.cfg.xml").buildSessionFactory();
		 Session ss = sessionFactory.openSession();
		 Transaction tx = ss.beginTransaction();
		 Employee emp = new Employee();		 
		 Company comp = (Company) ss.load(Company.class, 1);
		// comp.setComp_Name("Globe");
		// comp.setComp_Address("mha");
		// emp.setComp(comp);				 
		 emp.setEmp_Name("vikas p ");
		 emp.setEmp_Address("wakad oune ");
		 emp.setEmp_Salary(129.0);
		 System.out.println("[[[[[[[[["+comp);
		 emp.setComp_Id(comp.getComp_Id());
		 emp.setComp(comp);
		 ss.save(emp);
		 /*Employee emp = (Employee)ss.load(Employee.class, 1);
		 System.out.println(emp);
		 System.out.println(emp.getComp());*/
		 tx.commit();		 
		 //Company comp = emp.getComp();		
		 // System.out.println("[ emp: ]"+emp+"\n [ comp: ] "+comp);
		 
		 ss.close();	 
		 
	}

}

