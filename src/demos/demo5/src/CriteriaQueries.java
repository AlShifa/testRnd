import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import demo.Company;
import demo.Representative;

import util.HibernateUtil;


public class CriteriaQueries {
	static SessionFactory sf = HibernateUtil.getSessionfactory();
	public static void main(String[] args) {
		Session session = sf.openSession();
		Criteria crt = session.createCriteria(Representative.class);
		crt.createAlias("comp", "c");
		crt.add(Restrictions.ilike("c.name", "O%"));
		
		List<Representative> list =crt.list();
		for (Representative r : list) {
			System.out.println(r);
		}
	}

}
