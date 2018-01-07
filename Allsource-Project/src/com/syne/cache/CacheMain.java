package com.syne.cache;

import java.sql.SQLException;
import java.util.LinkedHashMap;

public class CacheMain {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		//create cache manager
		CacheManager cm = new CacheManager();
		
		//check data from cache
		Employee emp = cm.load(1);
		System.out.println(emp);				
		
		//expire Object
		cm.expireObject(1);
		
		//after expired it fetch from db
		System.out.println(cm.load(1));
		

	}

}
