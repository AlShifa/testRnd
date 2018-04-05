import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import demo.Dept;

import util.HibernateUtil;


public class Client {
	private static SessionFactory sf = HibernateUtil.getSessionfactory();
	
	public static void update(int deptno, String newDname, String newLoc)
	{
		Session session = null;
		Transaction tx = null;
		try{
			session = sf.openSession();
			tx = session.beginTransaction();
	/* attached object - update not required
	 * 		Dept d= (Dept)session.get(Dept.class,deptno);	
	 
			System.out.println("Got object d :" + d);	
			d.setDname(newDname);
			d.setLoc(newLoc);
	*/
/* new object + update command (only update command )
			Dept d = new Dept();
			d.setDeptno(deptno); d.setDname(newDname); d.setLoc(newLoc);
			session.update(d);
*/
			Dept d = new Dept();
			d.setDeptno(deptno); d.setDname(newDname); d.setLoc(newLoc);
			session.saveOrUpdate(d);
			
			tx.commit();
		}catch(Exception e)
		{
			System.out.println("Exception in update " + e);
			tx.rollback();
		}
		finally{
			session.close();
		}
			
	}
	
	
	
	public static void delete(int deptno)
	{
		Session session = null;
		Transaction tx = null;
		try{
			session = sf.openSession();
			tx = session.beginTransaction();
			
/*  create, delete but will not give exception if deptno does not exist
 * 			Dept d = new Dept();
			d.setDeptno(deptno);
			session.delete(d);
*/
	/*  load - lazy loading
		Dept d= (Dept)session.load(Dept.class,deptno);	
	*/
/* get - eager loading */ 
	Dept d= (Dept)session.get(Dept.class,deptno);	
	System.out.println("Got object d :" + d);	
		session.delete(d);	
			tx.commit();
		}catch(Exception e)
		{
			System.out.println("Exception in delete " + e);
			tx.rollback();
		}
		finally{
			session.close();
		}
		
	}
	
	
	public static void retrieve()
	{
		Session session = sf.openSession();
		Query query = session.createQuery("from Dept");
		List<Dept> depts = query.list();
		for (Dept dept : depts) {
			System.out.println(dept);
		}
		session.close();
	}
	
	public static void create(Dept d)
	{
		Session session = null;
		Transaction tx = null;
		try{
			session = sf.openSession();
			tx = session.beginTransaction();
			// d - transient object
			session.save(d);
			// d  - attached object
			
			// for attached object - primary key can not be modified
		    //d.setDeptno(111);
			
			//d.setLoc("Hyd");
			
			
			System.out.println("after save.............");
			tx.commit();
			// d - detached
			d.setDname("AAAAAAAAAAAAA");
			System.out.println("after commit ..............");
		}catch(Exception e)
		{
			System.out.println("Exception in insert " + e);
			tx.rollback();
		}
		finally{
			session.close();
		}
		
		
	}
	public static void main(String[] args) {
//		Dept d = new Dept();
//		d.setDeptno(30);
//		d.setDname("CCC");
//		d.setLoc("Pune");
//		create(d);
		
		//delete(300);
		update(100,"XXX","XXX");
		retrieve();
	}

}
