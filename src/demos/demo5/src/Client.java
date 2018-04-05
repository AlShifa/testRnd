import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import demo.Company;
import demo.Representative;
import util.HibernateUtil;


public class Client {
	static SessionFactory sf = HibernateUtil.getSessionfactory();
	
public static void insert()
	{
		Session session = null;
		Transaction tx = null;
		try
		{
				session = sf.openSession();
				tx = session.beginTransaction();
				Company comp = new Company();
					comp.setCno(2);
					comp.setName("Syn");
					comp.setAddr("Pune");
		 
					
			Representative r1 = new Representative();
			r1.setRno(201);
			r1.setName("varun");
			r1.setEmail("varun@syn");
			
			Representative r2 = new Representative();
			r2.setRno(202);
			r2.setName("202");
			r2.setEmail("202@gmail");
			
			
		r1.setComp(comp);
		r2.setComp(comp);
		
		
/*	session.save(comp);
 * comp.getReps().add(r1);
	comp.getReps().add(r2);
	*/	
			session.save(r1);
			session.save(r2);
		
			
					
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
	/*public static void modify()
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
			Sys
			tem.out.println(emp  + " , emails = "+ emp.getEmails());
		}
	}
	*/
	public static void main(String[] args) {
		insert();
	}

}
