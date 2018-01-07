package com.syne.cache;

import java.sql.SQLException;

public interface CacheManagerIF {
	
	void add(Integer empid ,Employee emp);
	public Employee load(Integer empid) throws SQLException;	
	public void expireObject(int empid);

}
