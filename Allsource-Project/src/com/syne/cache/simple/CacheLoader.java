package com.syne.cache.simple;

import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class CacheLoader {

	protected  Map<Integer, SoftReference<Employee>> cacheMap = new ConcurrentHashMap<Integer, SoftReference<Employee>>();
	protected  Map<Integer, Long> expirecacheMap = new ConcurrentHashMap<Integer, Long>();
	// private static DAO connection = new DAO();

	/** The default expiration date */
	private long defaultExpire = 10;
	
	public CacheLoader()
	{		
		// loading data ........
		System.out.println("loading data...making db connection....");		
		
	}	

	public void setCacheExpireTimeinSec(long defaultExpire) {
		this.defaultExpire = defaultExpire;
	}	

	public void add(Integer empid, Employee emp) {
		this.add(empid, emp, this.defaultExpire);

	}
	//putting the expire date as value into map.  
	public void add(Integer empid, Employee emp, final long expireTime) {
		this.cacheMap.put(empid, new SoftReference<Employee>(emp));
		this.expirecacheMap.put(empid, System.currentTimeMillis() + expireTime* 1000);
	}
	
	// fetch records from DB and add into cachemap
	static Employee fetchDBRecord(Integer empId) {
		System.out.println("fetching db data.....");
		return null;
	}

}
