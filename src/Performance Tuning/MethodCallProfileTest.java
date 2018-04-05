package com.mslc.training.methodprofiling;

import java.util.Hashtable;

public class MethodCallProfileTest {

	public static void main(String args[]) throws Exception {

		System.in.read();

		System.out.println("The used memory : "
				+ (Runtime.getRuntime().totalMemory() - Runtime.getRuntime()
						.freeMemory()) + "  Max : "
				+ Runtime.getRuntime().maxMemory());

		System.in.read();

		// new Test().runThreads();

		MethodCallProfileTest t = new MethodCallProfileTest();
		t.runThreads();

		System.in.read();

	}

	public void runThreads() {

		Thread t1 = new Thread(new Runnable() {

			public void run() {

				int repeat = 2000;

				// Let us create 2 arrays of numbers 8 of doubles and 10 of
				// longs

				double ds[] = new double[] { Double.MAX_VALUE, -3.14D,
						Double.NEGATIVE_INFINITY, 567.2130123D, 123e213D,
						-0.0122312, -1.2213213D, 1e55D };

				long ls[] = new long[] { 1232132132132L, -80021321323L,
						45232132131L, 54323243244L, 45L, Long.MAX_VALUE, 1L,
						-99999L, 76213123123L, 0L };

				// Following lines for initializations
				long time;
				StringBuffer s = new StringBuffer();
				String s2 = new String();
				Hashtable h = new Hashtable();
				System.out.println("Starting the test");

				time = System.currentTimeMillis();
				for (int i = repeat; i > 0; i--) {
					s.setLength(0);
					for (int j = ds.length - 1; j > 0; j--) {
						s.append(ds[j]);
						h.put(new Double(ds[j]), Boolean.TRUE);
					}

					for (int j = ls.length - 1; j > 0; j--) {
						s.append(ls[j]);
						h.put(new Long(ls[j]), Boolean.FALSE);
					}

				}

				time = System.currentTimeMillis() - time;
				System.out.println("The time taken in milliseconds is : "
						+ time + "I thread : "
						+ Thread.currentThread().getName());

			}

		});

		t1.start();
		// t2.start();

	}

}