package com.mslc.training.objectprofiling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ObjectCreationProfileTest {

	public static void main(String[] args) throws Exception {
		System.out.println("Hit enter to start");
		System.in.read();

		ObjectCreationProfileTest t1 = new ObjectCreationProfileTest();
		t1.runThreads();

	}

	public void runThreads() {

		Thread t1 = new Thread(new Runnable() {

			public void run() {

				long time = System.currentTimeMillis();

				List largeObjects = new ArrayList();
				for (int i = 0; i < 100; i++) {
					LargeObject l1 = new LargeObject(i);
					largeObjects.add(l1);

				}

				time = System.currentTimeMillis() - time;
				System.out.println(" Total time taken : " + time);
				try {
					System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		t1.start();

	}
}