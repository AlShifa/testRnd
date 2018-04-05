package com.syne.cache.simple;

public interface CacheManagerIF {
	
	public void add(Integer empid ,Employee emp);
	public void add(Integer empid, Employee emp, final long expireTime);
	public Employee get(Integer empid);	
	public void expireObject();
	public void setCacheExpireTimeinSec(long expiredate);

}
