import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;


public class SQLClient {
static SessionFactory sf= HibernateUtil.getSessionfactory();
	public static void main(String[] args) 
	{
		Session session = sf.openSession();
		SQLQuery query = session.createSQLQuery("select * from CompTable");
		ScrollableResults res = query.scroll();
		while(res.next())
		{
			System.out.println(res.get(0) + "\t"+ res.get(1));
		}
	}
}
