package munna.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class CAL<E> {//extends CAAL {

	public Object[] e = null;
	int capacity;
	int defaultcapacity = 10;
	int pointerOrSize;
	float loadfactor = 0.75f;
	int modCount;

	CAL() {
		this(20);		
	}

	CAL(int defaultcapacity) {		
		this(20,.75f);
		capacity = defaultcapacity;
	}

	CAL(int defaultcapacity, float loadfactor) {		
		capacity = defaultcapacity;		
		this.loadfactor = loadfactor;
		e = new Object[capacity];
	}

	private boolean ensureCapacity() {
		//with in threasold
		if (pointerOrSize+1 < (int) (capacity * loadfactor))
			return true;
		else
			return false;
	}
	void resize() {
		// if more than 75% used then increase the capacity by 50% and
		// resize it		
		int length = capacity;
		capacity = capacity + (int) (capacity * loadfactor);		
		e = Arrays.copyOf(e,capacity);	
	}
	void add(E value) {

		// CheckCapacity,
		if (ensureCapacity()) {
			e[pointerOrSize] = value;
			pointerOrSize++;
		} else {
			resize();// resize
			e[pointerOrSize] = value;
			pointerOrSize++;
		}
	}	

	void add(int index , E value) throws Exception {
		
		// CheckCapacity		
		if(index <= pointerOrSize)
		{			
			if (ensureCapacity()) {
				
				//take copy of index to pointerOrSize to temp
				Object objtemp = e[index];
				Object[] etemp = new Object[pointerOrSize - index];
				System.arraycopy(e, index, etemp, index, pointerOrSize);
				e[index]= value;
				//
				System.out.println(etemp.length);
				
			} else {
				
				resize();// resize
				e[pointerOrSize] = value;
				pointerOrSize++;
			}
			
		}else
		{throw new Exception("Index Out of BoundException ");}		
	}
	
	E get(int index)
	{
		if(index <= capacity)
		{
			Object obj = (Object)e[index];
			return (E)obj ;
		}
		return null;
	}
	
	E set(int index, E value)
	{	
		E temp = (E)e[index];
		e[index] = value;
		return temp;
	}
	
	void remove(int index)
	{
		if(index <= capacity)
		{
			e[index] = null;;
			
		}
		
	}
	void clear()
	{
		for(int i =0;i<size(); i++)
			e[i] = null; //do it null for gc ;
		pointerOrSize = 0;
			
	}
	public static void main(String[] args) {

		CAL<String> al = new CAL<String>();
		
		ArrayList<String> arl = new ArrayList<String>();
		//arl.
		arl.iterator();
		arl.add(null);
		arl.add(null);
		//System.out.println(arl.get(0));
		//LinkedHashMap<String, String> lnkedHshMap = new LinkedHashMap<String, String>();
	//	HashMap<K, V>
		//arl.
		//al.add("one");
		al.add("two");
		al.add("three");
		al.add("four");		
		//System.out.println(al.size());	
		//HashMap<K, V>
		//TreeMap<K, V>
		
		
		Collections.synchronizedList(arl);
	}
	int size() {
		return pointerOrSize;
	}

}
