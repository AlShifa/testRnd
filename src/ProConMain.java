package com.syne.thr.ms;

import java.util.Random;

public class ProConMain {
	
	public static void main(String[] args) {
		
		//final  ProConData proData = new ProConData(10);
		//final  ProConStackData proData = new ProConStackData(10);
		final  ProcConQueueData proData = new ProcConQueueData(10);
		
		//two producer threads
		(new Thread(){ 
			public void run(){
				int index =0;
				while(true)
				{					
					try {						
						Random randomGenerator = new Random();
						long element = randomGenerator.nextLong();
						proData.setData(element);
						index++;
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
		}}).start();
		
		(new Thread(){ 
			public void run(){
				int index =0;
				while(true)
				{					
					try {						
						Random randomGenerator = new Random();
						long element = randomGenerator.nextLong();
						proData.setData(element);
						index++;
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
		}}).start();
	//three consumer thread	
		(new Thread(){ public void run(){
			int index = 0;
			while(true)
			{				
				try {
					Long value = (Long)proData.getData();
					//System.out.println(value);
					Thread.sleep(500);
					index++;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}}).start();
		(new Thread(){ public void run(){
			int index = 0;
			while(true)
			{				
				try {
					Long value = (Long)proData.getData();
					//System.out.println(value);
					Thread.sleep(500);
					index++;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}}).start();
		(new Thread(){ public void run(){
			int index = 0;
			while(true)
			{				
				try {
					Long value = (Long)proData.getData();
					//System.out.println(value);
					Thread.sleep(500);
					index++;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}}).start();
		
	}

}
