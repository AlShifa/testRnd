import java.util.HashMap;

public class TestStringWrapper {

	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);

		String keyString = args[1]; // Will create keys based on this String

		HashMap str = new HashMap(); // HashMap using String keys
		HashMap strW = new HashMap(); // HashMap using StringWrapper keys
		Object o = new Object();

		for (int i = 0; i < 100; i++) { // Populate the HashMap objects
			str.put(keyString + i, o);
			strW.put(new StringWrapper(keyString + i), o);
		}

		String key = keyString + 1; // Some key in the table

		long start = System.currentTimeMillis(); // <+++ Start timing here
		for (int i = 0; i < n; i++) {
			Object o1 = str.get(key);
		}
		long stop = System.currentTimeMillis(); // <

		System.out.println("Time taken with String : " + (stop - start));

		start = System.currentTimeMillis(); // <+++ Start timing here
		StringWrapper sw = new StringWrapper("dummy");
		for (int i = 0; i < n; i++) {
			sw.recycle(key); // sw is a reference to a StringWrapper object
			Object o1 = strW.get(sw);
		}
		stop = System.currentTimeMillis(); // <+++ Stop timing here

		System.out.println("Time taken with StringWrapper : " + (stop - start));

	}

}
