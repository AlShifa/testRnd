package com.syne.thr;

import java.util.concurrent.*;
public class MyCallable implements Callable<Integer>
{
  public Integer call () throws Exception {
	  Integer sum = 10;	  
	  //for (int i = 0; i <= 100; i++) {
	      //sum += i;
	   //}	  
	  return sum;
  }
  
} // MyCallable 


