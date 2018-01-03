package com.syne.Z.go.core.thr.join;

public class MyRunnable implements Runnable {

	   public static void main(String[] args) {
	      Thread t = new Thread(new MyRunnable());
	      t.start();
	      t.setPriority(6);

	      for(int i=0; i<5; i++) {
	          System.out.println("Inside main"+Thread.currentThread());
	      }
	   }

	   public void run() {
	      for(int i=0; i<5; i++) {
	          System.out.println("Inside run"+Thread.currentThread());
	          Thread.yield();
	      }
	   }
	}
