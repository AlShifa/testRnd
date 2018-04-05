import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import demo.Dept;

import util.HibernateUtil;

public class Client {
	private static SessionFactory sf = HibernateUtil.getSessionfactory();

	public static void retrieve() {
		Session session = sf.openSession();
	
	Query query = session.getNamedQuery("tst");
		//uery query = session.createQuery("from Dept");
		//query.setCacheable(true);
		
		List<Dept> depts = query.list();
		for (Dept dept : depts) {
			System.out.println(dept);
		}
		System.out.println("------------------");
		List<Dept> deptss = query.list();
		for (Dept dept : deptss) {
			System.out.println(dept);
		}
		session.close();
	}

	public static void create(Dept d) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			session.save(d);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Exception in insert " + e);
			tx.rollback();
		} finally {
			session.close();
		}

	}

	public static void main(String[] args) {
/*		for (int i = 10 ; i<= 90; i = i+ 10)
		{
			Dept d = new Dept();
			d.setDeptno(i);
			d.setDname("dnameof"+i);
			if ((i % 20) ==0)
				d.setLoc("Pune");
			else
				d.setLoc("Hyd");
			create(d);	
		}
		*/
		retrieve();
		System.out.println("****************\n\n\n");
		retrieve();
		
	}
}
