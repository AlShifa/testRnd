package com.syne.cache.simple;

public class CacheMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//create cache manager
		CacheManager cm = new CacheManager();		
		cm.setCacheExpireTimeinSec(5);
		
		//added records into cache		
		cm.add(1001, new Employee(new Integer(1001), "Ashok", "pune"));		
		cm.add(1002,new Employee(new Integer(1002), "vijay", "hyd"));
		
		//check data from cache
		Employee emp = cm.get(1002);
		System.out.println(emp);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//check after expire date data is exist or not.
		System.out.println(cm.get(1002));
		

	}

}
