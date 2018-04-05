package com.syne.cache.simple;

import java.lang.ref.SoftReference;

public class CacheManager extends CacheLoader implements CacheManagerIF {

	
	@Override
	public Employee get(Integer empid) {

		SoftReference<Employee> empSR = cacheMap.get(empid);
		if (empSR != null) {
			Employee emp = empSR.get();

			// check the garbage collected or not
			if (emp != null) {				
				//check the expired data				
				final Long expireTime = this.expirecacheMap.get(empid);
				if (expireTime == null) return null;
				if (System.currentTimeMillis() > expireTime) {
					System.out.println("data is expired....");
					expireObject();
					return null;
				}else{
					System.out.println("data live... ");
					return emp;
				}

			} else {				
				// fetch new records from database
				Employee fetchEmp = fetchDBRecord(empid);
				add(empid,fetchEmp);
				return fetchEmp;

			}

		} else {
			// fetch records from database
			Employee fetchEmp = fetchDBRecord(empid);
			//added the fetched records into cache
			add(empid,fetchEmp);
			return fetchEmp;
		}

	}		

	@Override
	public void expireObject() {		
		Thread t =  new Thread(){public void run(){			
			for (Integer empid : expirecacheMap.keySet()) {				
				if (System.currentTimeMillis() > expirecacheMap.get(empid)) {					
					cacheMap.remove(empid);
					expirecacheMap.remove(empid);
				}
			}
			
		} };
		t.setDaemon(true);
		t.start();
		
	}
}
