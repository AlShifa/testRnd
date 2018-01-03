package com.syne.Z.go.core.MultiThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.Semaphore;

public class ClassSemaphore {	
	
	//Semaphore sema = new Semaphore(permits)
	//Object obj = new Object();
	public static void main(String[] args) {
		ClassSemaphore cla = new ClassSemaphore();
		//TreeMap<String, String> treeMap = new TreeMap<String, String>();
		Integer[] b = {3,5,1,9};
		
		List<Integer> aryList =  Arrays.asList(b);
		for (int i : b) {
			System.out.println(i);
		}
		System.out.println("[]"+b);
		Arrays.sort(b);
		
		for (int i : b) {
			System.out.println(i);
		}
	}
		//cla.m(null);
	}
	

