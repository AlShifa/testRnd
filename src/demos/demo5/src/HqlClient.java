import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import demo.Company;

import util.HibernateUtil;


public class HqlClient {
	static SessionFactory sf = HibernateUtil.getSessionfactory();
	public static void list()
	{
		Session session = sf.openSession();
		Query query= session.createQuery("from Company" );
		List<Company> cmps = query.list();
		for (Company company : cmps) {
			System.out.println(company);
		}
	}
	public static void iterate()
	{
		Session session = sf.openSession();
		Query query= session.createQuery("from Company" );
		Iterator<Company> it = query.iterate();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		}
	
	
	public static void scroll()
	{
		Session session = sf.openSession();
		Query query= session.createQuery("select cno,name  from Company" );
		ScrollableResults res = query.scroll();
		while(res.next())
		{
			System.out.println(res.get(0) + "\t" + res.get(1));
		}
	}
	public static void scroll1()
	{
		Session session = sf.openSession();
		//Query query= session.createQuery("SELECT cno, addr   from Company where addr  = :addrVar" );
		Query query = session.getNamedQuery("tst");
		query.setString("addrVar", "Hyd");
		ScrollableResults res = query.scroll();
		while(res.next())
		{
			System.out.println(res.get(0) + "\t" + res.get(1));
		}
	}
	
	public static void scroll2()
	{
		Session session = sf.openSession();
		Query query= 	session.createQuery("select r from Representative r where r.comp.name like '%O%'");
				
		ScrollableResults res = query.scroll();
		while(res.next())
		{
			System.out.println(res.get(0));
		}
	}
	public static void main(String[] args) {
		scroll2();
		//list();

	}

}
