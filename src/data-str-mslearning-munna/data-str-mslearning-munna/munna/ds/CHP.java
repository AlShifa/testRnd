package munna.ds;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class CHP<K,V> {
	
	private Entry[] heads;
	int noOfUsedBktORSIZE;
	private static class Entry<K,V>
    {
    	final K key;
    	V value;
    	int hash;
    	Entry<K,V> next;  
    	Entry(K k, V v,int hash,Entry<K,V> next)
    	{
    		this.key =k;
    		this.value=v;
    		this.hash=hash;
    		this.next =next;    		
    	}
    }    
    CHP()
    {
    	heads= new Entry[10]; 	    	
    	for(Object o : heads )
    		System.out.println(o);
    }
    
    V put(K k,V v)
    {
    	int hashValue = hashValue(k);
    	//if key are equals then override value else then add
    	Entry<K,V> obj = heads[hashValue];
    	if(obj!=null)
    	{
    		//some data is already since both has similar hash code ,
    		//then check any k.equals(e.key) in whole link list by travelser,
    		//if not equals then this is
    		//new key with same hvalue exist,then and add into header e[hvalue], 
    		//else
    		// then key is already exist ,we might be replace value and return old value    		
    		for(;obj!=null;obj=obj.next)
    		{
    			if(hashValue== obj.hash && (k.equals(obj.key) || k==obj.key))
    				{
    					V oldValue = obj.value; 
    					obj.value =v; //override the value
    					return oldValue;  					
    				}
    		}
    	}
    	heads[hashValue] = new Entry(k,v,hashValue,heads[hashValue]);    	
    	return null;
    }
    V get(K k)
    {
    	int hashCode = hashValue(k);
    	Entry<K, V> e = heads[hashCode];
    	//if e not null then value may be any where 
    	//in the list of same head or same bucket
    	if(e!=null)
    	{
    		for(;e!=null;e=e.next)
    		{
    			if((e.hash == hashCode) && (e.key.equals(k) || (e.key == k )))
    				return e.value;
    		}
    	}
    	return null;
    	
    }
    int hashValue(K k)
    {
    	int h = k.hashCode();
    	int v = h%heads.length;
    	System.out.println("[ hcode: ]"+h+"[ hashValue ]"+v);
    	return v;
    }
    public static void main(String[] args) {
    	
    	int k=1;
    	for(;k<10;k++)
    	{
    	 int parent = (k - 1) >>> 1;
    	 System.out.println(k-1+"[ ]"+parent);
    	}
    	/*Employee e1 = new Employee(1);
    	Employee e2 = new Employee(2);
    	CHP ch = new CHP();
    	ch.put(e1,1);
    	ch.put(e1,2);*/
    	//ch.put(e2,2);
    	//HashMap<K, V>
    	//ConcurrentHashMap<K, V>    
    	//LinkedHashMap<String, String> ll = new LinkedHashMap<String, String>();
    	//ll.put(key, value)
    	//IdentityHashMap<String, String> iden = new IdentityHashMap<String, String>();
    	//ArrayBlockingQueue<E>
    	//LinkedList<E>
    	//LinkedBlockingQueue<E>
    	//PriorityBlockingQueue<E>
    	//ConcurrentLinkedQueue<E>
    	//java.util.PriorityQueue<Integer> pq = new  java.util.PriorityQueue<Integer>();
    	//PriorityQueue<Integer> pq = new  PriorityQueue<Integer>();
    	PriorityQueue<Integer> pq = new  PriorityQueue<Integer>();
    	//System.out.println(" Data [ 1,9,6,2,5,7,11 ]");
    	/*pq.add(new Integer(9));
    	pq.add(new Integer(1));
    	pq.add(new Integer(6));
    	pq.add(new Integer(8));
    	pq.add(new Integer(2));*/
    	//pq.add(new Integer(2));
    	//pq.add(new Integer(5));
    	//pq.add(new Integer(7));
    	//pq.add(new Integer(11));    	
    	//System.out.println(pq);
    	
    	//System.out.println(pq.poll());
    	//System.out.println(pq);
    	/*for(Integer i:pq)
    		System.out.println(i);*/
    	
    	//ThreadPoolExecutor
    	
	}    

}
