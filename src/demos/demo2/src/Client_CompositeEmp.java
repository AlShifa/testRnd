import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import demo.CompositeEmp;
import demo.Emp;

import util.HibernateUtil;


public class Client_CompositeEmp {
	static SessionFactory sf = HibernateUtil.getSessionfactory();
	
	public static void insert(CompositeEmp e)
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
		List<CompositeEmp> emps = session.createQuery("from CompositeEmp" ).list();
		for (CompositeEmp emp : emps) {
			System.out.println(emp);
		}
	}
	public static void main(String[] args) {
		CompositeEmp emp = new CompositeEmp();
		emp.setProjNo("P1"); 	emp.setEmpno(10); emp.setEname("nameof10"); emp.setSalary(10000);
	insert(emp);
		
	CompositeEmp emp1 = new CompositeEmp();
	emp1.setProjNo("P2"); 	emp1.setEmpno(20); emp1.setEname("nameof20"); emp1.setSalary(20000);
insert(emp1);
list();

	}

}
