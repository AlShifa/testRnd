import java.util.concurrent.ConcurrentHashMap;


public class Concurent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConcurrentHashMap conMap = new ConcurrentHashMap();
		conMap.put("key", "value");

		Object value = conMap.get("key");
		
		Object obj = new Object();		
		System.out.println(obj);
		System.out.println(obj.hashCode());
		

		

	}

}
