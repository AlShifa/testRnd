import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import demo.Address;
import demo.Emp;

import util.HibernateUtil;


public class Client {
	static SessionFactory sf = HibernateUtil.getSessionfactory();
	
	public static void insert(Emp e)
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
	
	public void list()
	{
		Session session = sf.openSession();
		List<Emp> emps = session.createQuery("from Emp" ).list();
		for (Emp emp : emps) {
			System.out.println(emp);
		}
	}
	public static void main(String[] args) {
		Emp e= new Emp();
		e.setEmpno(10);
		e.setEname("AAA");
		e.setSalary(10000);
		e.getAddr().setLine1("hitech");
		e.getAddr().setCity("Hyd");
		e.getAddr().setState("AP");
		insert(e);
	}

}
