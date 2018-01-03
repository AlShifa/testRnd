package munna;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

import com.syne.collection.HashMapCustome;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		Runtime runtime  = Runtime.getRuntime();
		int x = runtime.availableProcessors();
		System.out.println(x);
		//HashMap<K, V>
		List<String> lst = new ArrayList<String>();
		lst.add("abc");
		lst.add("def");
		lst.add("2");
		List<String> lst2 = new ArrayList<String>();
		lst2.add("abc");
		lst2.add("1");
		lst2.add("2");
		//lst.retainAll(lst2);
		
		lst.removeAll(lst2);
		System.out.println(lst+"----"+lst2);
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(3, true);
		bq.put("1");
		bq.put("2");
		bq.put("3");		
		//Arrays.d		
		HashMapCustome<String, String> hmap = new HashMapCustome<String, String>();
		
		
		
	
	}
}
