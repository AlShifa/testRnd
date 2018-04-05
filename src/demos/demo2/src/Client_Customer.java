import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import demo.CompositeEmp;
import demo.Customer;
import demo.CustomerPK;
import demo.Emp;

import util.HibernateUtil;


public class Client_Customer {
	static SessionFactory sf = HibernateUtil.getSessionfactory();
	
	public static void insert(Customer e)
	{
		Session session = null;
		Transaction tx = null;
		try
		{
				session = sf.openSession();
				tx = session.beginTransaction();
				session.save(e);
				tx.commit();
		}
		catch(Exception err)
		{
				System.out.println("Exception in insert " + err);
				tx.rollback();
		}finally
		{
			session.close();
		}
		
	}
	
	public static  void list()
	{
		Session session = sf.openSession();
		List<Customer> emps = session.createQuery("from Customer" ).list();
		for (Customer emp : emps) {
			System.out.println(emp);
		}
	}
	public static void main(String[] args) {
		Customer c1 = new Customer();
		CustomerPK pk = new CustomerPK();
		pk.setCompName("Syn");
		pk.setAgentName("Ujwal");
		c1.setPk(pk);
		c1.setAddress("Hinj");
		insert(c1);
list();

	}

}
