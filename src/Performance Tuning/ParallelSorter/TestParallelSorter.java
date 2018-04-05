package com.mslc.training.parallelism.withcyclicbarrier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestParallelSorter {

	private static void $sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws InterruptedException, IOException {

		long start = System.currentTimeMillis();
		List<Integer> data = new ArrayList<Integer>();
		Random r = new Random();
		int totalValues = 1000000;
		for (int i = 0; i < totalValues; i++) {
			data.add(r.nextInt(totalValues));

		}

		long start1 = System.currentTimeMillis();
		Collections.sort(data);
		long end1 = System.currentTimeMillis();
		System.out.println("Time taken : " + (end1 - start1));

		ParallelSorter<Integer> sorter = new ParallelSorter<Integer>(data,
				new ReentrantReadWriteLock());
		long start2 = System.currentTimeMillis();

		sorter.sort();

		long end2 = System.currentTimeMillis();

		if ((end2 - start2) <= (end1 - start1)) {
			System.out
					.println("Time taken : " + (end2 - start2) + " & is  "
							+ (((end2 - start2) * 100) / (end1 - start1))
							+ " % faster");
		} else {
			System.out
			.println("Time taken : " + (end2 - start2) + " & is  "
					+ (((end1 - start1) * 100) / (end2 - start2))
					+ " % Slower");

		}
		long end = System.currentTimeMillis();
		
		System.out.println("Total Time :" + (end - start));
		System.in.read();

		// System.out.println(data);

	}
}
