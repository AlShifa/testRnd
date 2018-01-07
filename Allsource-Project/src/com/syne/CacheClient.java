package com.syne;
//CacheClient.java

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CacheClient {
	
	public static void main(String ar[]) {
		
		Configuration cfg = new Configuration();
		cfg.configure("/hibernate_cache.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Players p1 = new Players();
		p1.setPlayerId(1);
		p1.setPlayerName("Dhoni");
		p1.setAge(32);

		Players p2 = new Players();
		p2.setPlayerId(2);
		p2.setPlayerName("Kohli");
		p2.setAge(24);
		
		Players p3 = new Players();
		p3.setPlayerId(3);
		p3.setPlayerName("Rohit");
		p3.setAge(27);
		
		Set playerSet = new HashSet();
		playerSet.add(p1);
		playerSet.add(p2);
		playerSet.add(p3);
		
		//one-to-many
		Teams t1 = new Teams();
		t1.setTeamId(1);
		t1.setTeamName("Cricket");
		t1.setPlayers(playerSet);
		session.save(t1);
		
		session.flush();
		tx.commit();
		session.close();

		
		//fetch data from the database.
		/*Session s1 = sf.openSession();
		Transaction tx1 = s1.beginTransaction();
		Teams t3 = (Teams)s1.get(Teams.class, new Integer(1));
		System.out.println(t3.getTeamName());
		//Give time to session to write into second level cache.
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tx1.commit();
		s1.close();*/
		
		
		/*Session newSession = sf.openSession();
		Transaction tx2 = newSession.beginTransaction();
		System.out.println("After.....");
		Teams t4 = (Teams)newSession.get(Teams.class, new Integer(1));
		tx2.commit();
		newSession.close();
		*/
	}
}
