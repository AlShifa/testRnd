package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionfactory  ;

	static
	{
		try{
			sessionfactory = new Configuration().configure().buildSessionFactory();
			System.out.println("SessionFactory loaded");
		}catch(Exception e)
		{
			System.out.println("Exception in loading SessionFactory  :" + e.getMessage());
			e.printStackTrace();
		}
	}
	public static SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	
}
