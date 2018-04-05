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
	public static void modify()
	{
		Session session = null;
		Transaction tx = null;
		try
		{
				session = sf.openSession();
				tx = session.beginTransaction();
				Emp e = (Emp)session.get(Emp.class,20);
				e.getEmails().add("bbb@amdocs");
				e.getEmails().remove("bbb@gmail");
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
	
	public static void list()
	{
		Session session = sf.openSession();
		List<Emp> emps = session.createQuery("from Emp" ).list();
		session.close();
		for (Emp emp : emps) {
			System.out.println(emp  + " , emails = "+ emp.getEmails());
		}
	}
	public static void main(String[] args) {
	/*	Emp e= new Emp();
		e.setEmpno(20);
		e.setEname("BBB");
		e.setSalary(20000);
		e.getEmails().add("bbb@gmail");
		e.getEmails().add("bbb@fands");
		insert(e);
		*/
		//list(); 
		modify();
	}

}
