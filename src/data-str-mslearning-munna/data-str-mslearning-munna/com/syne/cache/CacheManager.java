package com.syne.cache;

import java.lang.ref.SoftReference;
import java.sql.SQLException;

public class CacheManager extends CacheLoader implements CacheManagerIF {

	@Override
	public Employee load(Integer empid) throws SQLException {

		SoftReference<Employee> empSR = cacheMap.get(empid);
		if (empSR != null) {
			Employee emp = empSR.get();

			// check the garbage collected or not
			if (emp != null) {
				System.out.println("returning emp from cache...."+emp);
				return emp;

			} else {
				// If the value has been garbage collected, remove the
				// entry from the HashMap
				cacheMap.remove(empid);
				// fetch new records from database
				Employee fetchEmp = fetchDBRecord(empid);
				add(empid,fetchEmp);
				return fetchEmp;

			}

		} else {
			// fetch records from database and added into cache.
			Employee fetchEmp = fetchDBRecord(empid);
			add(empid,fetchEmp);
			return fetchEmp;
		}

	}

	@Override
	public void add(Integer empid, Employee emp) {
		cacheMap.put(empid, new SoftReference<Employee>(emp));
	}	

	@Override
	public void expireObject(int empid) {
		System.out.println("expire data....");
		cacheMap.remove(empid);
	}

}
