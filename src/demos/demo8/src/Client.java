import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import demo.Account;
import demo.CurrentAccount;

import demo.SavingAccount;
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
		/*		Account acc = new Account();
				acc.setAcno("A01");
				acc.setBalance(1000);
				session.save(acc);
			*/
				SavingAccount sacc = new SavingAccount();
				sacc.setAcno("A02");
				sacc.setBalance(2000);
				sacc.setIntRate(10);
				sacc.setMinbalance(500);
				session.save(sacc);
				
				CurrentAccount cacc = new CurrentAccount();
				cacc.setAcno("A03");
				cacc.setBalance(3000);
				cacc.setOverdraft(5000);
				session.save(cacc);
				
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
	Query query = session.createQuery("from Account");
	List<Account> list = query.list();
	for (Account account : list) {
		System.out.println(account);
	}
	
}
	public static void main(String[] args) {
		insert();
		list();
	}

}
