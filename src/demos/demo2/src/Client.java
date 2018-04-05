import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
				Integer deptno = (Integer) session.save(e);
				System.out.println("inserting deptno = " + deptno);
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
	
		e.setEname("AAA");
		e.setSalary(10000);
		insert(e);
	}

}
