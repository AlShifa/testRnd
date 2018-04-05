import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import demo.Company;
import demo.Representative;
import util.HibernateUtil;


public class ModifyClient {
	static SessionFactory sf = HibernateUtil.getSessionfactory();
	
public static void modify()
	{
		Session session = null;
		Transaction tx = null;
		try
		{
				session = sf.openSession();
				tx = session.beginTransaction();
				
				List<Representative> list = session.createQuery("from Representative where comp.cno =2").list();
				Company comp =(Company) session.get(Company.class,4);
				for (Representative r : list) {
						r.setComp(comp);
				}
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
public static void modifywithHQL()
{
	Session session = null;
	Transaction tx = null;
	try
	{
			session = sf.openSession();
			tx = session.beginTransaction();
			
			Query query =  session.createQuery("update Representative r  set r.comp.cno = 2   where comp.cno = 4");
			System.out.println("No. of records updated =" +query.executeUpdate());
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
	public static void main(String[] args) {
	 //modify();
		modifywithHQL();
	}

}
