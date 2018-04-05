import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import demo.Person;
import demo.Event;

import util.HibernateUtil;


public class Client {
	static SessionFactory sf = HibernateUtil.getSessionfactory();
	

	public static void main(String[] args) {

			Session session = null;
			Transaction tx = null;
			try
			{
					session = sf.openSession();
					tx = session.beginTransaction();
					Person p = new Person();
					p.setPid("P1");
					p.setName("Test");
					p.setBdate(new Date());
					
					Event e = new Event();
					e.setEid(1); e.setDesc("Birthday ");
					
					e.getPeople().add(p);
					session.save(e);
					session.save(p);
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

}
